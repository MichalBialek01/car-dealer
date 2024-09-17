package pl.bialek.business.dao;

import pl.bialek.domain.Salesman;

import java.util.List;
import java.util.Optional;

public interface SalesmanDAO {
    Optional<Salesman> findByPesel(String pesel);

    List<Salesman> findAvailableSalesmen();

}
