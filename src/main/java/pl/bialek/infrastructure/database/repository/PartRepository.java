package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.PartDAO;
import pl.bialek.domain.Part;
import pl.bialek.infrastructure.database.repository.jpa.PartJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.PartEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PartRepository implements PartDAO {
    private final PartJpaRepository partJpaRepository;
    private final PartEntityMapper partEntityMapper;
    @Override
    public Optional<Part> findBySerialNumber(String serialNumber) {
        return partJpaRepository.findBySerialNumber(serialNumber)
                .map(partEntityMapper::mapFromEntity);
    }

    @Override
    public List<Part> findAll() {
        return partJpaRepository.findAll().stream()
                .map(partEntityMapper::mapFromEntity)
                .toList();
    }
}
