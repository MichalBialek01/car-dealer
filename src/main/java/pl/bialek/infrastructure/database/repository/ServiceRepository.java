package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.ServiceDAO;
import pl.bialek.domain.Service;
import pl.bialek.infrastructure.database.repository.jpa.ServiceJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.ServiceEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ServiceRepository implements ServiceDAO {
    private final ServiceJpaRepository serviceJpaRepository;
    private final ServiceEntityMapper serviceEntityMapper;
    @Override
    public Optional<Service> findByServiceCode(String serviceCode) {
        return serviceJpaRepository.findByServiceCode(serviceCode)
                .map(serviceEntityMapper::mapFromEntity);
    }

    @Override
    public List<Service> findAll() {
        return serviceJpaRepository.findAll().stream()
                .map(serviceEntityMapper::mapFromEntity)
                .toList();
    }
}
