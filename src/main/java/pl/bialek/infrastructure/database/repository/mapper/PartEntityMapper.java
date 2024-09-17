package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.Part;
import pl.bialek.infrastructure.database.entity.PartEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PartEntityMapper {
    @Mapping(target = "serviceParts", ignore = true)
    Part mapFromEntity(PartEntity partEntity);
}
