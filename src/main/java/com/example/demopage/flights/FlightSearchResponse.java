package com.example.demopage.flights;

import java.time.LocalDate;

public record FlightSearchResponse(String[][] prices) {

    public static FlightSearchResponse generateRandom(LocalDate departureDate, LocalDate returnDate) {
        String[][] prices = new String[][]{
                {
                        "", returnDate.minusDays(2).toString(), returnDate.minusDays(1).toString(), returnDate.toString(), returnDate.plusDays(1).toString(), returnDate.plusDays(2).toString(),
                },
                {
                        departureDate.minusDays(2).toString(), "€100", "€123", "€199", "€102", "€122",
                },
                {
                        departureDate.minusDays(1).toString(), "€99", "€103", "€299", "€201", "€112",
                },
                {
                        departureDate.toString(), "€101", "€102", "€199", "€202", "€101",
                },
                {
                        departureDate.plusDays(1).toString(), "€100", "€103", "€299", "€201", "€102",
                },
                {
                        departureDate.plusDays(2).toString(), "€99", "€103", "€299", "€201", "€112",
                },

        };


        return new FlightSearchResponse(prices);
    }
}
