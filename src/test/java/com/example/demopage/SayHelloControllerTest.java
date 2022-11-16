package com.example.demopage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SayHelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void sayHello() throws Exception {
        String url = "/api/v1/hello";

        MvcResult result = mockMvc
                .perform(post(url)
                        .contentType(APPLICATION_JSON)
                        .content(toJson(new HelloRequest("Samurai"))))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        HelloResponse response = fromJson(body, HelloResponse.class);
        assertThat(response.getValue()).isEqualTo("Hello, Samurai!");
    }

    private <T> T fromJson(String json, Class<T> klass) throws JsonProcessingException {
        return objectMapper.readValue(json, klass);
    }

    private String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}