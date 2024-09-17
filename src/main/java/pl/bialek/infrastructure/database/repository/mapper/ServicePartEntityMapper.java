package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.ServicePart;
import pl.bialek.infrastructure.database.entity.ServicePartEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServicePartEntityMapper {
    ServicePartEntity mapToEntity(ServicePart servicePart);
}
