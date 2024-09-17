package pl.bialek.business.dao;

import pl.bialek.domain.Mechanic;

import java.util.List;
import java.util.Optional;

public interface MechanicDAO {
    Optional<Mechanic> findByPesel(String pesel);

    List<Mechanic> findAvailableMechanics();
}
