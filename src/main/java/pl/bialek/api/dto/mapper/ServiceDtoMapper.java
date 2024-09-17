package pl.bialek.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.bialek.api.dto.ServiceDTO;
import pl.bialek.domain.Service;

@Mapper(componentModel = "spring")
public interface ServiceDtoMapper {
    ServiceDTO map(Service service);
}
