package com.example.service;

import com.example.domain.FlightPlan;
import com.example.repository.FlightRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    final FlightRepo flightRepo;


    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }


    public FlightPlan findById(String id){
        return flightRepo.findById(id).get();
    }

    public List<FlightPlan> findInternationalCrossing(String country){
        return flightRepo.findInternationalCrossing(country);
    }

    public List<FlightPlan> findFlightWhichLastBetweenOneAndThreeHours(){
        return flightRepo.findFlightPlansByFlightDurationBetween(60, 180, PageRequest.of(0,2));
    }

    public List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity(){
        return flightRepo.findFlightPlansByAircraftModelContainsOrderByAircraftSeatCapacityAsc("Boeing");
    }

}
