package pl.bialek.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarServiceRequestDTO {

    private String carServiceRequestNumber;
    private String receivedDateTime;
    private String completedDateTime;
    private String customerComment;
    private String carVin;
}
