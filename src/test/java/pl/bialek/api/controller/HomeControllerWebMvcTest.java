//package pl.bialek.api.controller;
//
//import lombok.AllArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//@WebMvcTest(controllers = HomeController.class)
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//class HomeControllerWebMvcTest {
//    private MockMvc mockMvc;
//    @Test
//    void homeWorksCorrectly() throws Exception {
//
//        mockMvc.perform(get(HomeController.HOME))
//                .andExpect(status().isOk())
//                .andExpect(view().name("home"));
//
//
//    }
//
//}