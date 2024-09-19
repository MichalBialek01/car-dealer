package pl.bialek.api.controller;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = HomeController.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
/*
onConstructor = @__(@Autowired) - mówi, że towrzony jest konstruktor, który jest oznaczony jako @Autowired
 */
class HomeControllerWebMvcTest {
    private MockMvc mockMvc;
//    Symuluje wysyałanie requesta

    @Test
    void homeWorksCorrectly() throws Exception {
//    GIVEN,WHEN,THEN
        mockMvc.perform(get(HomeController.HOME))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"));

//        Symulujemy wysłanie rquesta get na hontroler HomeController pod endpoint home
//        I oczekiwaną wartością jest status ok, oraz zwracanie nazwy homepage


    }

}