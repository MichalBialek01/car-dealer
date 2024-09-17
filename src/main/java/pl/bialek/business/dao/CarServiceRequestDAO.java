package pl.bialek.business.dao;

import pl.bialek.domain.CarServiceRequest;

import java.util.List;
import java.util.Set;

public interface CarServiceRequestDAO {
    Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin);

    List<CarServiceRequest> findAvailable();
}
