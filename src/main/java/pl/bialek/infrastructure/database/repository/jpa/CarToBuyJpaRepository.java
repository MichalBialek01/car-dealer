package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;

import java.util.List;
import java.util.Optional;

@Repository

public interface CarToBuyJpaRepository extends JpaRepository<CarToBuyEntity,Integer> {

    Optional<CarToBuyEntity> findByVin(String vin);

    /*
    N+1 possible if:
    @Query("""
    SELECT car FROM CarToBuyEntity car
    WHERE invoice.car.carToBuyId IS NULL;
    Because:
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
    private InvoiceEntity invoice;
    """)
    So for every CarToBuyEntity we need them to fetch invoice, so it's required to fetch
    all invoices (LEFT JOIN FETCH) so we are fetching
 */
    @Query("""
        SELECT car FROM CarToBuyEntity car
        LEFT JOIN FETCH car.invoice invoice
        WHERE invoice.car.carToBuyId IS NULL
        """)
    List<CarToBuyEntity> findAvailableCars();
}
