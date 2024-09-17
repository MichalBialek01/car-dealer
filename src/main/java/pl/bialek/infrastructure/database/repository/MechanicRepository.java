package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.MechanicDAO;
import pl.bialek.domain.Mechanic;
import pl.bialek.infrastructure.database.repository.jpa.MechanicJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.MechanicEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MechanicRepository implements MechanicDAO {
    private final MechanicJpaRepository mechanicJpaRepository;
    private final MechanicEntityMapper mechanicEntityMapper;

    @Override
    public Optional<Mechanic> findByPesel(String pesel) {
        return mechanicJpaRepository.findByPesel(pesel)
                .map(mechanicEntityMapper::mapFromEntity);
    }

    @Override
    public List<Mechanic> findAvailableMechanics() {
        return mechanicJpaRepository.findAll()
                .stream().map(mechanicEntityMapper::mapFromEntity).toList();
    }
}
