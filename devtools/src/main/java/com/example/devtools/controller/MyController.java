package com.example.devtools.controller;

import com.example.devtools.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    private final MyService myService;

    MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/process")
    public String process() {
        return myService.processData();
    }
}
