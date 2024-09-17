package pl.bialek.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarToBuyDTO {
    private String vin;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private BigDecimal price;
}
