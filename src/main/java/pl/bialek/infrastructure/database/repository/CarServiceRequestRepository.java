package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.CarServiceRequestDAO;
import pl.bialek.domain.CarServiceRequest;
import pl.bialek.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.CarServiceRequestEntityMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CarServiceRequestRepository implements CarServiceRequestDAO {
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final CarServiceRequestEntityMapper carServiceRequestEntityMapper;


    @Override
    public Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin) {
        return carServiceRequestJpaRepository.findActiveServiceRequestsByCarVin(carVin).stream()
                .map(carServiceRequestEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public List<CarServiceRequest> findAvailable() {
        return carServiceRequestJpaRepository.findAllByCompletedDateTimeIsNull().stream()
                .map(carServiceRequestEntityMapper::mapFromEntityWithCar)
                .toList();
    }
}
