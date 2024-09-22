package pl.bialek.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.bialek.api.dto.CarPurchaseRequestDTO;
import pl.bialek.api.dto.CarToBuyDTO;
import pl.bialek.domain.CarPurchaseRequest;
import pl.bialek.domain.CarToBuy;

@Mapper(componentModel="spring")
public interface CarPurchaseRequestDtoMapper {
    CarPurchaseRequest mapFromDTO(CarPurchaseRequestDTO carPurchaseRequestDTO);

    CarToBuyDTO map(CarToBuy car);

}
