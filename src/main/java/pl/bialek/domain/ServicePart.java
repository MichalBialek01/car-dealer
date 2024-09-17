package pl.bialek.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "servicePartId")
@ToString(of = {"servicePartId", "quantity"})
public class ServicePart {

    Integer servicePartId;
    Integer quantity;
    CarServiceRequest carServiceRequest;
    Part part;
}