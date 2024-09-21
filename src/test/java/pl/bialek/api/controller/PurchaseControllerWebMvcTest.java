//package pl.bialek.api.controller;
//
//import lombok.AllArgsConstructor;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.util.LinkedMultiValueMap;
//import pl.bialek.api.dto.CarPurchaseRequestDTO;
//import pl.bialek.api.dto.mapper.CarDtoMapper;
//import pl.bialek.api.dto.mapper.CarPurchaseRequestDtoMapper;
//import pl.bialek.business.CarPurchaseService;
//import pl.bialek.domain.Invoice;
//
//import java.util.Map;
//import java.util.stream.Stream;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(controllers = PurchaseController.class)
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//class PurchaseControllerWebMvcTest {
//
//    private MockMvc mockMvc;
//    @MockBean
//    private CarPurchaseService carPurchaseService;
//    @MockBean
//    private CarPurchaseRequestDtoMapper carPurchaseRequestDtoMapper;
//    @MockBean
//    private CarDtoMapper carDtoMapper;
//    @Test
//    void carPurchaseWorksCorrectlyForNewCostumer() throws Exception {
//        // given
//        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
//        CarPurchaseRequestDTO.buildDefaultCustomer().asMap().forEach(parameters::add);
//
//        Invoice expectedInvoice = Invoice.builder().invoiceNumber("test").build();
//        Mockito.when(carPurchaseService.purchase(Mockito.any())).thenReturn(expectedInvoice);
//
//        // when, then
//        mockMvc.perform(post(PurchaseController.PURCHASE).params(parameters))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("invoiceNumber"))
//                .andExpect(model().attributeExists("customerName"))
//                .andExpect(model().attributeExists("customerSurname"))
//                .andExpect(view().name("car_purchase_processed"));
//    }
//
//    @Test
//    void thatEmailValidationWorksCorrectly() throws Exception {
//        // given
//        String badEmail = "badEmail";
//        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
//        Map<String, String> parametersMap = CarPurchaseRequestDTO.buildDefaultCustomer().asMap();
//        parametersMap.put("customerEmail", badEmail);
//        parametersMap.forEach(parameters::add);
//
//        // when, then
//        mockMvc.perform(post(PurchaseController.PURCHASE).params(parameters))
//                .andExpect(status().isBadRequest())
//                .andExpect(model().attributeExists("errorMessage"))
//                .andExpect(model().attribute("errorMessage", Matchers.containsString(badEmail)))
//                .andExpect(view().name("error"));
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void thatPhoneValidationWorksCorrectly(Boolean correctPhone, String phone) throws Exception {
//        // given
//        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
//        Map<String, String> parametersMap = CarPurchaseRequestDTO.buildDefaultCustomer().asMap();
//        parametersMap.put("customerPhone", phone);
//        parametersMap.forEach(parameters::add);
//
//        // when,then
//        if (correctPhone) {
//            Invoice expectedInvoice = Invoice.builder().invoiceNumber("test").build();
//            Mockito.when(carPurchaseService.purchase(Mockito.any())).thenReturn(expectedInvoice);
//
//            mockMvc.perform(post(PurchaseController.PURCHASE).params(parameters))
//                    .andExpect(status().isOk())
//                    .andExpect(model().attributeExists("invoiceNumber"))
//                    .andExpect(model().attributeExists("customerName"))
//                    .andExpect(model().attributeExists("customerSurname"))
//                    .andExpect(view().name("car_purchase_done"));
//        } else {
//            mockMvc.perform(post(PurchaseController.PURCHASE).params(parameters))
//                    .andExpect(status().isBadRequest())
//                    .andExpect(model().attributeExists("errorMessage"))
//                    .andExpect(model().attribute("errorMessage", Matchers.containsString(phone)))
//                    .andExpect(view().name("error"));
//        }
//    }
//
//
//    public static Stream<Arguments> thatPhoneValidationWorksCorrectly() {
//        return Stream.of(
//                Arguments.of(false, ""),
//                Arguments.of(false, "+48 604 102 360##"),
//                Arguments.of(false, "+48-604-102-360"),
//                Arguments.of(false, "+44(987) 654-32-10-"),
//                Arguments.of(false, "+44(987) - 654-32-10"),
//                Arguments.of(false, "604.102.360"),
//                Arguments.of(false, " "),
//                Arguments.of(false, "+"),
//                Arguments.of(false, "!!"),
//                Arguments.of(false, "() ++ ()"),
//                Arguments.of(false, "(98 6666"),
//                Arguments.of(false, "+44 (11)"),
//                Arguments.of(false, "+"),
//                Arguments.of(false, " 2"),
//                Arguments.of(false, "2"),
//                Arguments.of(false, "+48 (22) 604 102 360"),
//                Arguments.of(false, "+48 (22) 604-102-360"),
//                Arguments.of(false, "+48(22)604102360"),
//                Arguments.of(false, "666-6666-666"),
//                Arguments.of(true, "+44 604 102 360")
//        );
//    }
//
//
//}