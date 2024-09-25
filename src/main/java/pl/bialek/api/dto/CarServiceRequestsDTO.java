package pl.bialek.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarServiceRequestsDTO {

    private List<CarServiceRequestDTO> carServiceRequests;
}
