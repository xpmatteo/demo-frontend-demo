package com.example.demopage.flights;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FlightSearchController {
    public static final int LEAVE_TIME_FOR_SEEING_THE_SPINNERS = 600;

    @PostMapping("/api/v1/flight-search")
    public FlightSearchResponse prices(@RequestBody FlightSearchRequest request) throws InterruptedException {
        System.out.println("Received request: " + request);

        Thread.sleep(LEAVE_TIME_FOR_SEEING_THE_SPINNERS);
        return FlightSearchResponse.generateRandom(
                LocalDate.parse(request.departureDate()),
                LocalDate.parse(request.returnDate()));
    }
}
