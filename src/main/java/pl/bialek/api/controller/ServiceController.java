package pl.bialek.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.bialek.api.dto.CarServiceCustomerRequestDTO;
import pl.bialek.api.dto.mapper.CarServiceRequestDtoMapper;
import pl.bialek.business.CarServiceRequestService;
import pl.bialek.domain.CarServiceRequest;

import java.util.Map;

@Controller
@AllArgsConstructor
public class ServiceController {
    private static final String SERVICE_NEW = "/service/new";
    private static final String SERVICE_REQUEST = "/service/request";
    private final CarServiceRequestDtoMapper carServiceRequestDtoMapper;
    private final CarServiceRequestService carServiceRequestService;


    @GetMapping(value = SERVICE_NEW)
    public ModelAndView carServicePage() {
        Map<String, ?> model = Map.of(
                "carServiceRequestDTO", CarServiceCustomerRequestDTO.buildDefault()
                );
        return new ModelAndView("car_service_request", model);
    }


    @PostMapping(value = SERVICE_REQUEST)
    public String processServiceRequest(
            @ModelAttribute("carServiceRequestDTO") CarServiceCustomerRequestDTO carServiceCustomerRequestDTO,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        CarServiceRequest carServiceRequest = carServiceRequestDtoMapper.map(carServiceCustomerRequestDTO);
        carServiceRequestService.processServiceRequest(carServiceRequest);

        return "car_service_request_done";
    }


}
