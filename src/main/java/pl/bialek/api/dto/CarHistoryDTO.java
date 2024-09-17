package pl.bialek.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bialek.domain.Service;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarHistoryDTO {

    private String carVin;
    private List<ServiceRequestDTO> carServiceRequests;

    public static CarHistoryDTO buildDefault() {
        return CarHistoryDTO.builder()
                .carVin("empty")
                .carServiceRequests(Collections.emptyList())
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ServiceRequestDTO {
        private String carServiceRequestNumber;
        private String receivedDateTime;
        private String completedDateTime;
        private String customerComment;
        private List<ServiceDTO> services;
        private List<PartDTO> parts;
    }
}
