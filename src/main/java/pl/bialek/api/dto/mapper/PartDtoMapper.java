package pl.bialek.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.bialek.api.dto.PartDTO;
import pl.bialek.domain.Part;

@Mapper(componentModel = "spring")
public interface PartDtoMapper {
    PartDTO map(Part part);

}
