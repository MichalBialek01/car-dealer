package pl.bialek.business.dao;

import pl.bialek.domain.CarToBuy;

import java.util.List;
import java.util.Optional;

public interface CarToBuyDAO {
    Optional<CarToBuy> findCarToBuyByVin(String vin);
    List<CarToBuy> findAvailable();

}
