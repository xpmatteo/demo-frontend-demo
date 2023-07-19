package com.example.demopage.flights;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FlightSearchController {

    @PostMapping("/api/v1/flight-search")
    public FlightSearchResponse prices(String request) {
        return FlightSearchResponse.generateRandom(LocalDate.now(), LocalDate.now().plusDays(30));
    }
}
