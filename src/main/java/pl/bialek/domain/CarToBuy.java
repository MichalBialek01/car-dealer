package pl.bialek.domain;

import lombok.*;

import java.math.BigDecimal;

@With
@Value
@Builder
@EqualsAndHashCode(of = "vin")
@ToString(of = {"carToBuyId", "vin", "brand", "model", "year"})
public class CarToBuy {

    Integer carToBuyId;
    String vin;
    String brand;
    String model;
    Integer year;
    String color;
    BigDecimal price;
    Invoice invoice;

}
