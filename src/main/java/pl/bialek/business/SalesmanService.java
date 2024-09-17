package pl.bialek.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bialek.business.dao.SalesmanDAO;
import pl.bialek.domain.Salesman;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SalesmanService {
    private final SalesmanDAO salesmanDAO;

    public Salesman findSalesman(String pesel) {
        Optional<Salesman> salesman = salesmanDAO.findByPesel(pesel);
        if (salesman.isEmpty()) {
            throw new RuntimeException("Provided salesman with pesel: [%s] doesn't exist".formatted(pesel));
        }
        return salesman.get();
    }

    public List<Salesman> findAvailableSalesmen() {
        return salesmanDAO.findAvailableSalesmen();

    }
}
