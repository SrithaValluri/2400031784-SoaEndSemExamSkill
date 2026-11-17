package com.klu.springmvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddition() throws Exception {

        mockMvc.perform(get("/ms1/add")
                .param("a", "10")
                .param("b", "20"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("addition"))
                .andExpect(jsonPath("$.result")
                        .value(30));
    }
}
