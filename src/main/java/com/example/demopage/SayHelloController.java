package com.example.demopage;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

    @PostMapping(value = "/api/v1/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloResponse> sayHello(@RequestBody HelloRequest request) {
        String message = String.format("Hello, %s!", request.getName());
        return ResponseEntity.ok(new HelloResponse(message));
    }
}
