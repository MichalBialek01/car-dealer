package pl.bialek.api.controller.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bialek.api.dto.CarPurchaseRequestDTO;
import pl.bialek.api.dto.CarsToBuyDTO;
import pl.bialek.api.dto.InvoiceDTO;
import pl.bialek.api.dto.mapper.CarPurchaseRequestDtoMapper;
import pl.bialek.api.dto.mapper.InvoiceDtoMapper;
import pl.bialek.business.CarPurchaseService;
import pl.bialek.domain.CarPurchaseRequest;
import pl.bialek.domain.Invoice;

@RestController
@AllArgsConstructor
@RequestMapping(PurchaseRestController.API_PURCHASE)
public class PurchaseRestController {


    public static final String API_PURCHASE = "/api/purchase";

    private final CarPurchaseService carPurchaseService;
    private final CarPurchaseRequestDtoMapper carPurchaseRequestDtoMapper;
    private final InvoiceDtoMapper invoiceDtoMapper;

    @GetMapping
    public CarsToBuyDTO carsPurchaseData() {
        return CarsToBuyDTO.builder()
                .carsToBuy(carPurchaseService.availableCars().stream()
                        .map(carPurchaseRequestDtoMapper::map)
                        .toList())
                .build();
    }

    @PostMapping
    public InvoiceDTO makePurchase(
            @Valid @RequestBody CarPurchaseRequestDTO carPurchaseDTO
    ) {
        CarPurchaseRequest carPurchaseRequest = carPurchaseRequestDtoMapper.mapFromDTO(carPurchaseDTO);
        Invoice invoice = carPurchaseService.purchase(carPurchaseRequest);
        return invoiceDtoMapper.map(invoice);
    }

}
