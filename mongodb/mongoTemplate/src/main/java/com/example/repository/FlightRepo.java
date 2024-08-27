package com.example.repository;

import com.example.domain.Aircraft;
import com.example.domain.AircraftFactory;
import com.example.domain.FlightPlan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.BooleanOperators.*;

@Repository
public class FlightRepo {

    final MongoOperations mongoOperations;

    public FlightRepo(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public FlightPlan findById(String id){
        return mongoOperations.findById(id, FlightPlan.class);
    }

    public List<FlightPlan> findInternationalCrossingFrance() {
        var isInternational = Criteria.where("isInternational").is(true);
        var crossingFrance = Criteria.where("crossedCountries").in("France");
        var criteria = new Criteria().andOperator(List.of(isInternational, crossingFrance));
        var query = new Query(criteria);

        return this.mongoOperations.find(query, FlightPlan.class);
    }

    public List<FlightPlan> findFirstTwoFlightsWhichLstBetweenOneAndThreeHours(){

        var durationisBigger = Criteria.where("flightDuration").gte(60);
        var durationisLess = Criteria.where("flightDuration").lte(180);

        var duration = new Criteria().andOperator(durationisBigger, durationisLess);
        var query = new Query(duration).with(PageRequest.of(0,2));
        return this.mongoOperations.find(query, FlightPlan.class);

    }


    public List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity(){
        var isBoeing = Criteria.where("aircraft.model").regex("Boeing");

        var query = new Query(isBoeing).with(Sort.by("aircraft.capacity").ascending());
        return this.mongoOperations.find(query, FlightPlan.class);
    }

    public List<FlightPlan> findByFullTextSearch(String value){
        var txtCriteria = TextCriteria.forDefaultLanguage().matching(value);

        var query = new TextQuery(txtCriteria).sortByScore();
        return this.mongoOperations.find(query, FlightPlan.class);
    }

    public void incrementDepartureTime(String id, LocalDateTime newDepartureTime) {
        var query = Query.query(Criteria.where("id").is(id));
        var departureTime = Update.update("departureDateTime", newDepartureTime);

        mongoOperations.updateFirst(query,departureTime,FlightPlan.class);

    }

    public void changeDurationForFlightsInParis(Integer minutesToAdd) {
        var query = Query.query(Criteria.where("departure").regex("Paris"));
        var incTime = new Update().inc("flightDuration", minutesToAdd);

        mongoOperations.updateMulti(query,incTime,FlightPlan.class);

    }






        public void insertInitialFlightPlans() {
        // Insert a single document
        var parisToLondon = new FlightPlan(
                "Paris",
                "London",
                LocalDateTime.of(2023, 6, 1, 20, 15),
                90,
                List.of("France", "England"),
                true,
                AircraftFactory.buildBoeing737()
        );
        this.mongoOperations.save(parisToLondon);

        // Insert a list of documents
        var parisToNice = new FlightPlan(
                "Paris, France",
                "Nice, France",
                LocalDateTime.of(2023, 7, 3, 9, 0),
                100,
                List.of("France"),
                false,
                AircraftFactory.buildEmbraerE175()
        );

        var istanbulToPhuket = new FlightPlan(
                "Istanbul, Turkey",
                "Phuket, Thailand",
                LocalDateTime.of(2023, 12, 15, 22, 50),
                600,
                List.of("Turkey", "Iran", "Pakistan", "India", "Thailand"),
                true,
                AircraftFactory.buildAirbusA350()
        );

        var istanbulToBucharest = new FlightPlan(
                "Istanbul, Turkey",
                "Bucharest, Romania",
                LocalDateTime.of(2023, 12, 15, 21, 30),
                600,
                List.of("Turkey", "Romania"),
                true,
                AircraftFactory.buildBoeing737()
        );

        var berlinToNewYork = new FlightPlan(
                "Berlin, Germany",
                "New York, United States",
                LocalDateTime.of(2023, 9, 5, 15, 0),
                420,
                List.of("Germany", "England", "United States"),
                true,
                AircraftFactory.buildBoeing747()
        );

        var viennaToBucharest = new FlightPlan(
                "Vienna, Austria",
                "Bucharest, Romania",
                LocalDateTime.of(2023, 8, 1, 11, 30),
                75,
                List.of("Austria", "Hungary", "Romania"),
                true,
                AircraftFactory.buildBoeing737()
        );

        var flightPlans = List.of(
                parisToNice,
                viennaToBucharest,
                berlinToNewYork,
                istanbulToPhuket,
                istanbulToBucharest
        );

        mongoOperations.insert(flightPlans, FlightPlan.class);
    }
}
