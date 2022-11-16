package com.example.demopage;

import com.fasterxml.jackson.annotation.JsonCreator;

public class HelloResponse {
    private final String value;

    @JsonCreator
    public HelloResponse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
