package pl.bialek.business.dao;

import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToService;

import java.util.List;
import java.util.Optional;

public interface CarToServiceDAO {
    Optional<CarToService> findCarToServiceByVin(String vin);

    CarToService saveCarToService(CarToService carToService);

    CarHistory findCarHistoryByVin(String vinNumber);

    List<CarToService> findAll();
}
