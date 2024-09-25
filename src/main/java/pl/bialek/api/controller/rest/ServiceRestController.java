package pl.bialek.api.controller.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bialek.api.dto.CarServiceCustomerRequestDTO;
import pl.bialek.api.dto.CarServiceRequestDTO;
import pl.bialek.api.dto.CarServiceRequestsDTO;
import pl.bialek.api.dto.mapper.CarServiceDtoRequestMapper;
import pl.bialek.api.dto.mapper.CarServiceRequestDtoMapper;
import pl.bialek.business.CarServiceRequestService;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarServiceRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(ServiceRestController.API_SERVICE)
public class ServiceRestController {

    public static final String API_SERVICE = "/api/service";
    public static final String SERVICE_REQUEST = "/request";

    private final CarServiceRequestService carServiceRequestService;
    private final CarServiceRequestDtoMapper carServiceRequestDtoMapper;

    @PostMapping(value = SERVICE_REQUEST)
    public CarServiceRequestsDTO processServiceRequest(
            @Valid @RequestBody CarServiceCustomerRequestDTO carServiceCustomerRequestDTO) {
        CarServiceRequest carServiceRequest = carServiceRequestDtoMapper.map(carServiceCustomerRequestDTO);
        carServiceRequestService.processServiceRequest(carServiceRequest);
        return CarServiceRequestsDTO.builder()
                .carServiceRequests(getAvailableCarServiceRequests())
                .build();


    }

    private List<CarServiceRequestDTO> getAvailableCarServiceRequests() {
        return carServiceRequestService.availableServiceRequests().stream()
                .map(carServiceRequestDtoMapper::map)
                .collect(Collectors.toList());
    }

}