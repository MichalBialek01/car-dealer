package pl.bialek.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.bialek.api.dto.CarServiceCustomerRequestDTO;
import pl.bialek.api.dto.CarServiceMechanicProcessingUnitDTO;
import pl.bialek.api.dto.CarServiceRequestDTO;
import pl.bialek.domain.*;

@Mapper(componentModel = "spring")
public interface CarServiceRequestDtoMapper extends OffsetDateTimeMapper{
    default CarServiceRequest map(CarServiceCustomerRequestDTO dto) {
        if (dto.isNewCar()) {
            return CarServiceRequest.builder()
                    .customer(Customer.builder()
                            .name(dto.getCustomerName())
                            .surname(dto.getCustomerSurname())
                            .phone(dto.getCustomerPhone())
                            .email(dto.getCustomerEmail())
                            .address(Address.builder()
                                    .country(dto.getCustomerAddressCountry())
                                    .city(dto.getCustomerAddressCity())
                                    .postalCode(dto.getCustomerAddressPostalCode())
                                    .address(dto.getCustomerAddressStreet())
                                    .build())
                            .build())
                    .car(CarToService.builder()
                            .vin(dto.getCarVin())
                            .brand(dto.getCarBrand())
                            .model(dto.getCarModel())
                            .year(dto.getCarYear())
                            .build())
                    .customerComment(dto.getCustomerComment())
                    .build();
        } else {
            return CarServiceRequest.builder()
                    .customer(Customer.builder()
                            .email(dto.getExistingCustomerEmail())
                            .build())
                    .car(CarToService.builder()
                            .vin(dto.getExistingCarVin())
                            .build())
                    .customerComment(dto.getCustomerComment())
                    .build();
        }
    }

    @Mapping(source = "car.vin", target = "carVin")
    @Mapping(source = "receivedDateTime", target = "receivedDateTime", qualifiedByName = "mapOffsetDateTimeToString")
    @Mapping(source = "completedDateTime", target = "completedDateTime", qualifiedByName = "mapOffsetDateTimeToString")
    CarServiceRequestDTO map(CarServiceRequest request);

    @Mapping(source = "mechanicComment", target = "comment")
    CarServiceProcessingRequest map(CarServiceMechanicProcessingUnitDTO dto);

}
