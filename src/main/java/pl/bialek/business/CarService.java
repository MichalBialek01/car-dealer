package pl.bialek.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.bialek.business.dao.CarToBuyDAO;
import pl.bialek.business.dao.CarToServiceDAO;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToBuy;
import pl.bialek.domain.CarToService;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Slf4j
public class CarService {

    private final CarToServiceDAO carToServiceDAO;
    private final CarToBuyDAO carToBuyDAO;

    public CarToBuy findCarToBuy(String vin) {
        Optional<CarToBuy> carToBuyByVin = carToBuyDAO.findCarToBuyByVin(vin);
        if (carToBuyByVin.isEmpty()) {
            throw new RuntimeException("Provided car with vin: [%s] doesn't exist".formatted(vin));
        }
        return carToBuyByVin.get();
    }

    public Optional<CarToService> findCarToService(String vin) {
        return carToServiceDAO.findCarToServiceByVin(vin);
    }

    public CarToService saveCarToService(CarToBuy carToBuy) {
        CarToService carToService = CarToService.builder()
                .vin(carToBuy.getVin())
                .brand(carToBuy.getBrand())
                .model(carToBuy.getModel())
                .year(carToBuy.getYear())
                .build();
        return carToServiceDAO.saveCarToService(carToService);
    }

    public CarToService saveCarToService(CarToService carToService) {
        return carToServiceDAO.saveCarToService(carToService);
    }

    public List<CarToBuy> findAvailableCars() {
        return carToBuyDAO.findAvailable();

    }

    public List<CarToService> findAllCarsWithHistory() {
        return carToServiceDAO.findAll();
    }

    public CarHistory findCarHistoryByVin(String carVin) {
        return carToServiceDAO.findCarHistoryByVin(carVin);

    }
}
