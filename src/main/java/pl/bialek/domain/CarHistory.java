package pl.bialek.domain;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.List;

@Value
@Builder
@ToString(of = "carVin")
public class CarHistory {

    String carVin;
    List<CarServiceRequest> carServiceRequests;

    @Value
    @Builder
    @ToString(of = {"carServiceRequestNumber", "receivedDateTime", "completedDateTime", "customerComment"})
    public static class CarServiceRequest {
        String carServiceRequestNumber;
        OffsetDateTime receivedDateTime;
        OffsetDateTime completedDateTime;
        String customerComment;
        List<Service> services;
        List<Part> parts;
    }
}
