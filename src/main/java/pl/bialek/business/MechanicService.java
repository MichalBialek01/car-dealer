package pl.bialek.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bialek.business.dao.MechanicDAO;
import pl.bialek.domain.Mechanic;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class MechanicService {

    private final MechanicDAO mechanicDAO;

    public Mechanic findMechanic(String pesel) {
        Optional<Mechanic> mechanic = mechanicDAO.findByPesel(pesel);
        if (mechanic.isEmpty()) {
            throw new RuntimeException("Provided mechanic with pesel: [%s] doesn't exist".formatted(pesel));
        }
        return mechanic.get();
    }

    public List<Mechanic> findAvailableMechanics() {
        return mechanicDAO.findAvailableMechanics();
    }
}
