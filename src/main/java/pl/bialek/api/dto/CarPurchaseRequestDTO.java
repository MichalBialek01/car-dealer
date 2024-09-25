package pl.bialek.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPurchaseRequestDTO {

    @Email
    private String existingCustomerEmail;
    private String customerName;
    private String customerSurname;
    @Email
    private String customerEmail;
    @Size
    @Pattern(regexp = "^[+]\\d{2}\\s\\d{3}\\s\\d{3}\\s\\d{3}$")
    private String customerPhone;
    private String customerAddressCountry;
    private String customerAddressCity;
    private String customerAddressPostalCode;
    private String customerAddressStreet;

    private String carVin;
    private String salesmanPesel;

    //    Only for testing purposes
    public static CarPurchaseRequestDTO buildDefaultCustomer() {
        return CarPurchaseRequestDTO.builder()
                .customerName("Michal")
                .customerSurname("Bialek")
                .customerEmail("michal.bialek@mail.com")
                .customerPhone("+48 123 456 789")
                .customerAddressCountry("Poland")
                .customerAddressCity("Wroclaw")
                .customerAddressPostalCode("50-339")
                .customerAddressStreet("Reja")
                .build();
    }

    public Map<String, String> asMap() {
        Map<String, String> result = new HashMap<>();
        ofNullable(customerName).ifPresent(value -> result.put("customerName", value));
        ofNullable(customerSurname).ifPresent(value -> result.put("customerSurname", value));
        ofNullable(customerPhone).ifPresent(value -> result.put("customerPhone", value));
        ofNullable(customerEmail).ifPresent(value -> result.put("customerEmail", value));
        ofNullable(existingCustomerEmail).ifPresent(value -> result.put("existingCustomerEmail", value));
        ofNullable(customerAddressCountry).ifPresent(value -> result.put("customerAddressCountry", value));
        ofNullable(customerAddressCity).ifPresent(value -> result.put("customerAddressCity", value));
        ofNullable(customerAddressPostalCode).ifPresent(value -> result.put("customerAddressPostalCode", value));
        ofNullable(customerAddressStreet).ifPresent(value -> result.put("customerAddressStreet", value));
        ofNullable(carVin).ifPresent(value -> result.put("carVin", value));
        ofNullable(salesmanPesel).ifPresent(value -> result.put("salesmanPesel", value));
        return result;
    }
}
