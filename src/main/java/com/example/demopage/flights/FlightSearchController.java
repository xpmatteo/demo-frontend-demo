package com.example.demopage.flights;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FlightSearchController {

    @PostMapping("/api/v1/flight-search")
    public FlightSearchResponse prices(FlightSearchRequest request) {
        System.out.println(request.toString());
        return FlightSearchResponse.generateRandom(
                LocalDate.parse(request.departureDate()),
                LocalDate.parse(request.returnDate()));
    }
}
