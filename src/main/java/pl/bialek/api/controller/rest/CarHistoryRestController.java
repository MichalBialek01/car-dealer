package pl.bialek.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bialek.api.dto.CarHistoryDTO;
import pl.bialek.api.dto.mapper.CarDtoMapper;
import pl.bialek.business.CarService;
import pl.bialek.domain.exception.NotFoundException;

import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping(CarHistoryRestController.API_CAR)
public class CarHistoryRestController {

    public static final String API_CAR = "/api/car";
    public static final String CAR_VIN_HISTORY = "/{carVin}/history";


    private final CarService carService;
    private final CarDtoMapper carDtoMapper;

    @GetMapping(value = CAR_VIN_HISTORY)
    public ResponseEntity<CarHistoryDTO> carHistory(
            @PathVariable String carVin
    ) {
        if (Objects.isNull(carVin)) {
            throw new NotFoundException("Car History for vin: [%s] not found".formatted(carVin));
        }
        return ResponseEntity
                .ok(carDtoMapper
                        .map(carService.findCarHistoryByVin(carVin)));

    }

}
