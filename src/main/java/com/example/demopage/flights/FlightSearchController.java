package com.example.demopage.flights;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FlightSearchController {

    @PostMapping("/api/v1/flight-search")
    public FlightSearchResponse prices(@RequestBody FlightSearchRequest request) throws JsonProcessingException {
        System.out.println("Received request: " + request);

        return FlightSearchResponse.generateRandom(
                LocalDate.parse(request.departureDate()),
                LocalDate.parse(request.returnDate()));
    }
}
