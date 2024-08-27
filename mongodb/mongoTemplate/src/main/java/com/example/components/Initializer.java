package com.example.components;

import com.example.service.FlightService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Initializer implements CommandLineRunner {
    private final  FlightService flightService;

    public Initializer(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public void run(String... args) throws Exception {
       //flightService.initData();

       // System.out.println(flightService.findInternationalCrossingFrance());
       // System.out.println(flightService.findFirstTwoFlightsWhichLstBetweenOneAndThreeHours());
       //System.out.println(flightService.findBoeingFlightsAndOrderBySeatCapacity());
      //  System.out.println(flightService.findByFullTextSearch("France"));
      //  flightService.incrementDepartureTime("66cadeb66b2c122ce4833aee", LocalDateTime.now());
        flightService.changeDurationForFlightsInParis(10);
    }
}
