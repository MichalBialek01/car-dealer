package pl.bialek.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.bialek.api.dto.CarPurchaseRequestDTO;
import pl.bialek.domain.CarPurchaseRequest;

@Mapper(componentModel="spring")
public interface CarPurchaseRequestDtoMapper {
    CarPurchaseRequest mapFromDTO(CarPurchaseRequestDTO carPurchaseRequestDTO);
}
