package pl.bialek.util;

import lombok.experimental.UtilityClass;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;

import java.math.BigDecimal;

@UtilityClass
public class EntityFixtures {

    public static CarToBuyEntity car1() {
        return CarToBuyEntity.builder()
                .vin("DSED324324WDW1")
                .brand("BMW")
                .model("3")
                .year(2023)
                .color("red")
                .price(new BigDecimal(100))
                .build();
    }

    public static CarToBuyEntity car2() {
        return CarToBuyEntity.builder()
                .vin("DFS42F32442")
                .brand("Audi")
                .model("S3")
                .year(2022)
                .color("black")
                .price(new BigDecimal(123))
                .build();
    }

}
