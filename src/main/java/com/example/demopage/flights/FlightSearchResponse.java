package com.example.demopage.flights;

import java.time.LocalDate;
import java.util.Map;

public record FlightSearchResponse(Map<LocalDate, Map<LocalDate, String>> prices) {

}
