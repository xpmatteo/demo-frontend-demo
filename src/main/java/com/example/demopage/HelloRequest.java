package com.example.demopage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloRequest {
    @JsonProperty
    private String name;

    @JsonCreator
    public HelloRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
