package pl.bialek.business;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import pl.bialek.business.dao.ServiceRequestProcessingDAO;
import pl.bialek.domain.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class CarServiceProcessingService {
    private final MechanicService mechanicService;
    private final CarService carService;
    private final CarServiceRequestService carToServiceRequestService;
    private final ServiceCatalogService serviceCatalogService;
    private final PartCatalogService partCatalogService;
    private final ServiceRequestProcessingDAO serviceRequestProcessingDAO;


    @Transactional
    public void process(CarServiceProcessingRequest request) {
        Mechanic mechanic = mechanicService.findMechanic(request.getMechanicPesel());
        carService.findCarToService(request.getCarVin()).orElseThrow();
        CarServiceRequest serviceRequest = carToServiceRequestService.findAnyActiveServiceRequest(request.getCarVin());

        Service service = serviceCatalogService.findService(request.getServiceCode());

        ServiceMechanic serviceMechanic = buildServiceMechanic(request, mechanic, serviceRequest, service);

        if (request.getDone()) {
            serviceRequest = serviceRequest.withCompletedDateTime(OffsetDateTime.of(2030, 12, 12, 21, 37, 10, 0, ZoneOffset.UTC));
        }

        if (request.partNotIncluded()) {
            serviceRequestProcessingDAO.process(serviceRequest, serviceMechanic);
        } else {
            Part part = partCatalogService.findPart(request.getPartSerialNumber());
            ServicePart servicePart = buildServicePart(request, serviceRequest, part);
            serviceRequestProcessingDAO.process(serviceRequest, serviceMechanic, servicePart);
        }
    }

    private ServicePart buildServicePart(
            CarServiceProcessingRequest request,
            CarServiceRequest carServiceRequest,
            Part part) {

        return ServicePart
                .builder()
                .quantity(request.getPartQuantity())
                .carServiceRequest(carServiceRequest)
                .part(part)
                .build();
    }

    private ServiceMechanic buildServiceMechanic(
            CarServiceProcessingRequest request,
            Mechanic mechanic,
            CarServiceRequest carServiceRequest,
            Service service) {

        return ServiceMechanic.builder()
                .hours(request.getHours())
                .comment(request.getComment())
                .carServiceRequest(carServiceRequest)
                .service(service)
                .mechanic(mechanic)
                .build();
    }

}
