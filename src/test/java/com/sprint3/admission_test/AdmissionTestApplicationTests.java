package com.sprint3.admission_test;

import java.awt.PageAttributes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AdmissionTestApplicationTests {

    @Autowired
    private MockMvc mockmvc ;

    @Test
    public void contextLoads() throws Exception {

        mockmvc.perform(MockMvcRequestBuilders.get("/api/medications").contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

}
