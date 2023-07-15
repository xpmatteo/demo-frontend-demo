package com.example.demopage.flights;

public record FlightSearchRequest(
        String departureAirport,
        String arrivalAirport,
        String departureDate,
        String returnDate,
        int numberOfAdults,
        int numberOfChildren,
        int numberOfInfants,
        String currencyCode
        ) {}
