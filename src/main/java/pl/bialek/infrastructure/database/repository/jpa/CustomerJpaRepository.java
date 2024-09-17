package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.infrastructure.database.entity.CustomerEntity;

import java.util.Optional;

@Repository

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {


    Optional<CustomerEntity> findByEmail(String email);
}
