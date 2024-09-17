package pl.bialek.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.bialek.api.dto.*;
import pl.bialek.api.dto.mapper.CarServiceRequestDtoMapper;
import pl.bialek.api.dto.mapper.MechanicDtoMapper;
import pl.bialek.api.dto.mapper.PartDtoMapper;
import pl.bialek.api.dto.mapper.ServiceDtoMapper;
import pl.bialek.business.CarServiceProcessingService;
import pl.bialek.business.CarServiceRequestService;
import pl.bialek.business.PartCatalogService;
import pl.bialek.business.ServiceCatalogService;
import pl.bialek.domain.CarServiceProcessingRequest;
import pl.bialek.domain.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MechanicController {
    public static final String MECHANIC = "/mechanic";
    public static final String MECHANIC_WORK_UNIT = "/mechanic/workUnit";


    private final CarServiceProcessingService carServiceProcessingService;
    private final CarServiceRequestService carServiceRequestService;
    private final PartCatalogService partCatalogService;
    private final ServiceCatalogService serviceCatalogService;
    private final CarServiceRequestDtoMapper carServiceRequestDtoMapper;


    private final MechanicDtoMapper mechanicDtoMapper;
    private final PartDtoMapper partDtoMapper;
    private final ServiceDtoMapper serviceDtoMapper;

    @GetMapping(value = MECHANIC)
    public ModelAndView mechanicCheckPage(){
        Map<String, ?> data = prepareNecessaryData();
        return new ModelAndView("mechanic_service",data);
    }

    private Map<String, ?> prepareNecessaryData() {
        var availableServiceRequests = getAvailableServiceRequests();
        var availableCarVins = availableServiceRequests.stream().map(CarServiceRequestDTO::getCarVin).toList();
        var availableMechanics = getAvailableMechanics();
        var availableMechanicPesels = availableMechanics.stream().map(MechanicDTO::getPesel).toList();
        var parts = findParts();
        var services = findServices();
        var partSerialNumbers = preparePartSerialNumbers(parts);
        var serviceCodes = services.stream().map(ServiceDTO::getServiceCode).toList();


        return Map.of(
                "availableServiceRequestDTOs", availableServiceRequests,
                "availableCarVins", availableCarVins,
                "availableMechanicDTOs", availableMechanics,
                "availableMechanicPesels", availableMechanicPesels,
                "partDTOs", parts,
                "partSerialNumbers", partSerialNumbers,
                "serviceDTOs", services,
                "serviceCodes", serviceCodes,
                "carServiceProcessDTO", CarServiceMechanicProcessingUnitDTO.buildDefault()
        );
    }

    @PostMapping(value = MECHANIC_WORK_UNIT)
    public String mechanicWorkUnit(
            @ModelAttribute("carServiceRequestProcessDTO") CarServiceMechanicProcessingUnitDTO dto,
            BindingResult bindingResult,
            ModelMap modelMap
    ) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        CarServiceProcessingRequest request = carServiceRequestDtoMapper.map(dto);
        carServiceProcessingService.process(request);
        if (dto.getDone()) {
            return "mechanic_service_done";
        } else {
            modelMap.addAllAttributes(prepareNecessaryData());
            return "redirect:/mechanic";
        }
    }

    private List<CarServiceRequestDTO> getAvailableServiceRequests() {
        return carServiceRequestService.availableServiceRequests().stream()
                .map(carServiceRequestDtoMapper::map)
                .toList();
    }

    private List<MechanicDTO> getAvailableMechanics() {
        return carServiceRequestService.availableMechanics().stream()
                .map(mechanicDtoMapper::map)
                .toList();
    }

    private List<PartDTO> findParts() {
        return partCatalogService.findAll().stream()
                .map(partDtoMapper::map)
                .toList();
    }

    private List<ServiceDTO> findServices() {
        return serviceCatalogService.findAll().stream()
                .map(serviceDtoMapper::map)
                .toList();
    }

    private List<String> preparePartSerialNumbers(List<PartDTO> parts) {
        List<String> partSerialNumbers = new ArrayList<>(parts.stream()
                .map(PartDTO::getSerialNumber)
                .toList());
        partSerialNumbers.add(Part.NONE);
        return partSerialNumbers;
    }


}
