package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;

import java.util.Optional;

@Repository

public interface CarToServiceJpaRepository extends JpaRepository<CarToServiceEntity,Integer> {

@EntityGraph(
        type = EntityGraph.EntityGraphType.FETCH,
        attributePaths = {
                "carServiceRequests",
                "carServiceRequests.serviceMechanics",
                "carServiceRequests.serviceMechanics.service",
                "carServiceRequests.serviceParts",
                "carServiceRequests.serviceParts.part"

        }
)
    CarToServiceEntity findCarHistoryByVin(String vinNumber);

    Optional<CarToServiceEntity> findByVin(String vin);
}
