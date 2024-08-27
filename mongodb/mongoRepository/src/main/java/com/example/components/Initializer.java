package com.example.components;

import com.example.service.FlightService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
    private final  FlightService flightService;

    public Initializer(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public void run(String... args) throws Exception {
       //flightService.initData();

       // System.out.println(flightService.findInternationalCrossing("France"));
       // System.out.println(flightService.findFlightWhichLastBetweenOneAndThreeHours());
       System.out.println(flightService.findBoeingFlightsAndOrderBySeatCapacity());
    }
}
