package pl.bialek.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarServiceCustomerRequestDTO {


    private String existingCustomerEmail;

    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerPhone;
    private String customerAddressCountry;
    private String customerAddressCity;
    private String customerAddressPostalCode;
    private String customerAddressStreet;

    private String existingCarVin;

    private String carVin;
    private String carBrand;
    private String carModel;
    private Integer carYear;

    private String customerComment;

    public static CarServiceCustomerRequestDTO buildDefault() {
        return CarServiceCustomerRequestDTO.builder()
                .existingCustomerEmail("michal.bialek@gmail.com")
                .existingCarVin("WBA5A7C50FD737019")
                .customerComment("Rozrząd do wymiany")
                .build();
    }

    public boolean isNewCar() {
        return Objects.isNull(getExistingCustomerEmail())
                || getExistingCustomerEmail().isBlank()
                || Objects.isNull(getExistingCarVin())
                || getExistingCarVin().isBlank();
    }
}
