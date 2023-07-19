package com.example.demopage.flights;

public record FlightSearchRequest(
        String departureAirport,
        String arrivalAirport,
        String departureDate,
        String returnDate,
        Integer adults,
        Integer children,
        Integer infants,
        String currency
        ) {}
