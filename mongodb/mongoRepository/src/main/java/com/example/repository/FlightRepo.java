package com.example.repository;

import com.example.domain.FlightPlan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends MongoRepository<FlightPlan, String> {

    @Query("{'isInternational' : true, 'crossedCountries' : { '$in' : [?0]}}")
    List<FlightPlan> findInternationalCrossing(String country);

    List<FlightPlan> findFlightPlansByFlightDurationBetween(int minDuration, int maxDuration, PageRequest pageRequest);

     List<FlightPlan> findFlightPlansByAircraftModelContainsOrderByAircraftSeatCapacityAsc(String model);

}
