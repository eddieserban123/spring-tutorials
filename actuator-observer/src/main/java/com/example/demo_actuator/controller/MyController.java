package com.example.demo_actuator.controller;

import com.example.demo_actuator.service.MyService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final Counter visitCounter;
    private final MyService myService;

    MyController(MyService myService, MeterRegistry meterRegistry){
        this.visitCounter = Counter.builder("visit_counter")
                .description("Number of visits to the site")
                .register(meterRegistry);
        this.myService = myService;
    }



    @GetMapping("/process")
    public String process() {
        visitCounter.increment();
        return myService.processData();
    }
}
