package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping("/greet")
    public String greet() {
        return greetingMessage;
    }
}