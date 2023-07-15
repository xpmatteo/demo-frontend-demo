package com.example.demopage.flights;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
public class FlightSearchController {

    @PostMapping("/api/v1/flight-search")
    public FlightSearchResponse prices(String request) {
        Map<LocalDate, Map<LocalDate, String>> prices = Map.of(
                LocalDate.parse("2021-09-01"), Map.of(
                        LocalDate.parse("2021-09-02"), "EUR 123.00"
                )
        );
        return new FlightSearchResponse(prices);
    }
}
