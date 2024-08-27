package com.example.service;

import com.example.domain.FlightPlan;
import com.example.repository.FlightRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    final FlightRepo flightRepo;


    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public void initData() {
        flightRepo.insertInitialFlightPlans();
    }

    public FlightPlan findById(String id) {
        return flightRepo.findById(id);
    }

    public List<FlightPlan> findInternationalCrossingFrance() {
        return flightRepo.findInternationalCrossingFrance();
    }

    public List<FlightPlan> findFirstTwoFlightsWhichLstBetweenOneAndThreeHours() {
        return flightRepo.findFirstTwoFlightsWhichLstBetweenOneAndThreeHours();
    }

    public List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity() {
        return flightRepo.findBoeingFlightsAndOrderBySeatCapacity();
    }

    public List<FlightPlan> findByFullTextSearch(String value) {
        return flightRepo.findByFullTextSearch(value);
    }

    public void incrementDepartureTime(String id, LocalDateTime newDepartureTime) {
        flightRepo.incrementDepartureTime(id, newDepartureTime);
    }

    public void changeDurationForFlightsInParis(Integer minutesToAdd) {
        flightRepo.changeDurationForFlightsInParis(minutesToAdd);
    }
}
