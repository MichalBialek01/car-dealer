package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CarServiceRequestJpaRepository extends JpaRepository<CarServiceRequestEntity,Integer> {
    @Query("""
        SELECT carServiceRequest FROM CarServiceRequestEntity carServiceRequest
        WHERE carServiceRequest.completedDateTime IS NULL
        AND
        carServiceRequest.car.vin = :vin
""")
    Set<CarServiceRequestEntity> findActiveServiceRequestsByCarVin(final @Param("vin") String carVin);

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "car"
            }
    )
    Set<CarServiceRequestEntity> findAllByCompletedDateTimeIsNull();
}
