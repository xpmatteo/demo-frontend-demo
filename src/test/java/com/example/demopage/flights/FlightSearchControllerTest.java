package com.example.demopage.flights;

import com.example.demopage.HelloResponse;
import com.example.demopage.flights.FlightSearchRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FlightSearchControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getPrices() throws Exception {
        String url = "/api/v1/flight-search";

        MvcResult result = mockMvc
                .perform(post(url)
                        .contentType(APPLICATION_JSON)
                        .content(toJson(new FlightSearchRequest("LIN", "FCO", "2021-09-01", "2021-09-02", 1, 0, 0, "EUR"))))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        FlightSearchResponse response = fromJson(body, FlightSearchResponse.class);
    }

    private <T> T fromJson(String json, Class<T> klass) throws JsonProcessingException {
        return objectMapper.readValue(json, klass);
    }

    private String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
