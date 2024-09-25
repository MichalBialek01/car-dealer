package pl.bialek.api.controller.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bialek.api.dto.CarServiceMechanicProcessingUnitDTO;
import pl.bialek.api.dto.CarServiceRequestDTO;
import pl.bialek.api.dto.CarServiceRequestsDTO;
import pl.bialek.api.dto.mapper.CarServiceRequestDtoMapper;
import pl.bialek.business.CarServiceProcessingService;
import pl.bialek.business.CarServiceRequestService;
import pl.bialek.domain.CarServiceProcessingRequest;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(MechanicRestController.API_MECHANIC)
public class MechanicRestController {

    public static final String API_MECHANIC = "/api/mechanic";
    public static final String AVAILABLE_SERVICE_REQUESTS = "/availableServiceRequests";
    public static final String MECHANIC_WORK_UNIT = "/workUnit";

    private final CarServiceRequestService carServiceRequestService;
    private final CarServiceProcessingService carServiceProcessingService;
    private final CarServiceRequestDtoMapper carServiceRequestDtoMapper;


    @GetMapping(value = AVAILABLE_SERVICE_REQUESTS)
    public CarServiceRequestsDTO getAvailableServiceRequests(){
        return CarServiceRequestsDTO.builder()
                .carServiceRequests(getAvailableCarServiceRequests())
                .build();
    }

    @PostMapping(value = MECHANIC_WORK_UNIT)
    public CarServiceRequestsDTO mechanicPerformWorkUnit(
            @Valid @RequestBody CarServiceMechanicProcessingUnitDTO processingUnitDTO
    ) {
        CarServiceProcessingRequest request = carServiceRequestDtoMapper.map(processingUnitDTO);
        carServiceProcessingService.process(request);
        return getAvailableServiceRequests();
    }

    private List<CarServiceRequestDTO> getAvailableCarServiceRequests() {
        return carServiceRequestService.availableServiceRequests().stream()
                .map(carServiceRequestDtoMapper::map)
                .toList();
    }

}
