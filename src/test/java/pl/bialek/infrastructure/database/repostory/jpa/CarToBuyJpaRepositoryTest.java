//package pl.bialek.infrastructure.database.repostory.jpa;
//
//import lombok.AllArgsConstructor;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.TestPropertySource;
//import pl.bialek.configuration.PersistenceContainerTestConfiguration;
//import pl.bialek.infrastructure.database.entity.CarToBuyEntity;
//import pl.bialek.infrastructure.database.repository.jpa.CarToBuyJpaRepository;
//
//import java.util.List;
//
//import static pl.bialek.util.EntityFixtures.car1;
//import static pl.bialek.util.EntityFixtures.car2;
//
//@DataJpaTest
//@TestPropertySource(locations = "classpath:application-test.yaml")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(PersistenceContainerTestConfiguration.class)
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//public class CarToBuyJpaRepositoryTest {
//
//    private CarToBuyJpaRepository carToBuyJpaRepository;
//
//
//    @Test
//    void thatCarCanBeSavedCorrectly() {
////      Given
//        var carsToBuy = List.of(car1(), car2());
//        carToBuyJpaRepository.saveAllAndFlush(carsToBuy);
////      When
//        List<CarToBuyEntity> savedCars = carToBuyJpaRepository.findAvailableCars();
////      Then
//        Assertions.assertThat(savedCars).hasSize(8);
//    }
//}
