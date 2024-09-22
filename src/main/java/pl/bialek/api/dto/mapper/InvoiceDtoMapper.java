package pl.bialek.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.bialek.api.dto.InvoiceDTO;
import pl.bialek.domain.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceDtoMapper extends OffsetDateTimeMapper {

    InvoiceDTO map(Invoice invoice);
}
