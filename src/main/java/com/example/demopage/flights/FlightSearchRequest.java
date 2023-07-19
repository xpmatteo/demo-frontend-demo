package com.example.demopage.flights;

public record FlightSearchRequest(
        String departureAirport,
        String arrivalAirport,
        String departureDate,
        String returnDate,
        int adults,
        int children,
        int infants,
        String currency
        ) {}
