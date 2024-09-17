package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.CarToServiceDAO;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToService;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;
import pl.bialek.infrastructure.database.repository.jpa.CarToServiceJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.CarToServiceEntityMapper;

import java.util.List;
import java.util.Optional;
@Repository
@AllArgsConstructor
public class CarToServiceRepository implements CarToServiceDAO {

    private final CarToServiceJpaRepository carToServiceJpaRepository;
    private final CarToServiceEntityMapper carToServiceEntityMapper;
    @Override
    public Optional<CarToService> findCarToServiceByVin(String vin) {
        return carToServiceJpaRepository.findByVin(vin)
                .map(carToServiceEntityMapper::mapFromEntity);
    }

    @Override
    public CarToService saveCarToService(CarToService carToService) {
        CarToServiceEntity carToServiceEntity =  carToServiceEntityMapper.mapToEntity(carToService);
        CarToServiceEntity saved = carToServiceJpaRepository.save(carToServiceEntity);
        return carToServiceEntityMapper.mapFromEntity(saved);
    }

    @Override
    public CarHistory findCarHistoryByVin(String vinNumber) {
        CarToServiceEntity carHistoryByVin = carToServiceJpaRepository.findCarHistoryByVin(vinNumber);
        return carToServiceEntityMapper.mapFromEntity(vinNumber,carHistoryByVin);
    }

    @Override
    public List<CarToService> findAll() {
        return carToServiceJpaRepository.findAll()
                .stream()
                .map(carToServiceEntityMapper::mapFromEntity)
                .toList();
    }
}
