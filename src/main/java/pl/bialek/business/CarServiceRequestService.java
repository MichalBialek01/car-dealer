package pl.bialek.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bialek.business.dao.CarServiceRequestDAO;
import pl.bialek.domain.*;
import pl.bialek.domain.exception.NotFoundException;
import pl.bialek.domain.exception.ProcessingException;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@AllArgsConstructor
public class CarServiceRequestService {
    private final CarService carService;
    private final CustomerService customerService;
    private final CarServiceRequestDAO carServiceRequestDAO;
    private final MechanicService mechanicService;

    public List<Mechanic> availableMechanics() {
        return mechanicService.findAvailableMechanics();
    }


    @Transactional
    public void processServiceRequest(CarServiceRequest serviceRequest) {
        if (serviceRequest.getCar().previouslyExistedInCarToBuy()) {
            saveServiceRequestForExistedCar(serviceRequest);
        } else {
            saveServiceRequestForNewCar(serviceRequest);
        }
    }

    private void saveServiceRequestForExistedCar(CarServiceRequest serviceRequest) {
        validate(serviceRequest.getCar().getVin());

        CarToService car = carService.findCarToService(serviceRequest.getCar().getVin())
                .orElse(findInCarToBuyAndSaveInCarToService(serviceRequest.getCar()));
        Customer customer = customerService.findCustomer(serviceRequest.getCustomer().getEmail());

        CarServiceRequest carServiceRequest = buildCarServiceRequest(serviceRequest, car, customer);
        Set<CarServiceRequest> existingCarServiceRequests = customer.getCarServiceRequests();
        existingCarServiceRequests.add(carServiceRequest);
        customerService.saveServiceRequest(customer.withCarServiceRequests(existingCarServiceRequests));
    }


    private void saveServiceRequestForNewCar(CarServiceRequest serviceRequest) {
        validate(serviceRequest.getCar().getVin());

        CarToService car = carService.saveCarToService(serviceRequest.getCar());
        Customer customer = customerService.saveCustomer(serviceRequest.getCustomer());

        CarServiceRequest carServiceRequest = buildCarServiceRequest(serviceRequest, car, customer);
        Set<CarServiceRequest> existingCarServiceRequests = customer.getCarServiceRequests();
        existingCarServiceRequests.add(carServiceRequest);
        customerService.saveServiceRequest(customer.withCarServiceRequests(existingCarServiceRequests));
    }

    private void validate(String carVin) {
        Set<CarServiceRequest> serviceRequests = carServiceRequestDAO.findActiveServiceRequestsByCarVin(carVin);
        if (serviceRequests.size() == 1) {
            throw new ProcessingException(
                    "There should be only one active service request at a time, car vin: [%s]".formatted(carVin)
            );
        }
    }

    private CarToService findInCarToBuyAndSaveInCarToService(CarToService car) {
        CarToBuy carToBuy = carService.findCarToBuy(car.getVin());
        return carService.saveCarToService(carToBuy);
    }

    private CarServiceRequest buildCarServiceRequest(
            CarServiceRequest request,
            CarToService car,
            Customer customer
    ) {
        OffsetDateTime when = OffsetDateTime.of(2027, 1, 10, 10, 2, 10, 0, ZoneOffset.UTC);
        return CarServiceRequest.builder()
                .carServiceRequestNumber(generateCarServiceRequestNumber(when))
                .receivedDateTime(when)
                .customerComment(request.getCustomerComment())
                .customer(customer)
                .car(car)
                .build();
    }

    private String generateCarServiceRequestNumber(OffsetDateTime when) {
        return "%s.%s.%s-%s.%s.%s.%s".formatted(
                when.getYear(),
                when.getMonth().ordinal(),
                when.getDayOfMonth(),
                when.getHour(),
                when.getMinute(),
                when.getSecond(),
                randomInt(10, 100)
        );
    }

    private int randomInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    @Transactional
    public CarServiceRequest findAnyActiveServiceRequest(String carVin) {
        Set<CarServiceRequest> serviceRequests = carServiceRequestDAO.findActiveServiceRequestsByCarVin(carVin);
        if (serviceRequests.size() != 1) {
            throw new ProcessingException(
                "There should be only one active service request at a time, car vin: [%s]".formatted(carVin));
        }
        return serviceRequests.stream()
            .findAny()
            .orElseThrow(() -> new NotFoundException("Could not find any service requests, car vin: [%s]".formatted(carVin)));
    }

    public List<CarServiceRequest> availableServiceRequests() {
        return carServiceRequestDAO.findAvailable();
    }
}
