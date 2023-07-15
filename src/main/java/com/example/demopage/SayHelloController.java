package com.example.demopage;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
public class SayHelloController {

    public static final int LEAVE_TIME_FOR_SEEING_THE_SPINNERS = 600;

    @PostMapping(value = "/api/v1/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sayHello(@RequestBody HelloRequest request) throws InterruptedException {
        if (isNull(request.getName())) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Missing parameter 'name'"));
        }
        String message = String.format("Hello, %s!", request.getName());
        Thread.sleep(LEAVE_TIME_FOR_SEEING_THE_SPINNERS);
        return ResponseEntity.ok(new HelloResponse(message));
    }
}
