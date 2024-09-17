package pl.bialek.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Objects;

@With
@Value
@Builder
public class CarServiceProcessingRequest {

    String mechanicPesel;
    String carVin;
    String partSerialNumber;
    Integer partQuantity;
    String serviceCode;
    Integer hours;
    String comment;
    Boolean done;

    public boolean partNotIncluded() {
        return Objects.isNull(getPartSerialNumber())
            || Objects.isNull(getPartQuantity())
            || Part.NONE.equals(getPartSerialNumber());
    }
}