package pl.bialek.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Builder
@Value
public class CarServiceProcessingInputData {

    String mechnicPesel;
    String carVin;
    String partSerialNumber;
    Integer partQuantity;
    String serviceCode;
    Integer hours;
    String comment;
    String done;
}
