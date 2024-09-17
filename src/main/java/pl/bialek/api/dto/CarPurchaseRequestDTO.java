package pl.bialek.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPurchaseRequestDTO {

    private String existingCustomerEmail;

    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerPhone;
    private String customerAddressCountry;
    private String customerAddressCity;
    private String customerAddressPostalCode;
    private String customerAddressStreet;

    private String carVin;
    private String salesmanPesel;

//    Only for testing purposes
    public static CarPurchaseRequestDTO buildDefaultCustomer(){
        return CarPurchaseRequestDTO.builder()
                .customerName("Michal")
        .customerSurname("Bialek")
        .customerEmail("michal.bialek@mail.com")
        .customerPhone("886345246")
        .customerAddressCountry("Poland")
        .customerAddressCity("Wroclaw")
        .customerAddressPostalCode("50-339")
        .customerAddressStreet("Reja")
        .build();
    }

}
