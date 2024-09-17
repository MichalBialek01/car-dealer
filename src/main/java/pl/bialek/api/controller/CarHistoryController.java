package pl.bialek.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bialek.api.dto.CarHistoryDTO;
import pl.bialek.api.dto.CarToServiceDTO;
import pl.bialek.api.dto.mapper.CarDtoMapper;
import pl.bialek.business.CarService;
import pl.bialek.domain.CarHistory;

import java.util.Objects;

@Controller
@AllArgsConstructor
public class CarHistoryController {
    public static final String CAR_HISTORY = "/car/history";
    private final CarService carService;
    private final CarDtoMapper carDtoMapper;



    @GetMapping(value = CAR_HISTORY)
    public String carHistory(@RequestParam(value = "carVin",required = false)String carVin,
                             Model model){

        var allCars = carService.findAllCarsWithHistory().stream().map(carDtoMapper::map).toList();
        var allCarVins = allCars.stream().map(CarToServiceDTO::getVin).toList();

        model.addAttribute("allCarDTOs", allCars);
        model.addAttribute("allCarVins", allCarVins);

        if (Objects.nonNull(carVin)) {
            CarHistory carHistory = carService.findCarHistoryByVin(carVin);
            model.addAttribute("carHistoryDTO", carDtoMapper.map(carHistory));
        } else {
            model.addAttribute("carHistoryDTO", CarHistoryDTO.buildDefault());
        }
        return "car_history";
    }
}
