package com.kodilla.good.patterns.PrivateFlights;

import com.kodilla.good.patterns.PrivateFlights.exceptions.AirportAlreadyExistsExecution;

import java.util.*;

public class FlightDataBase {
    private Map<String,List<String>> flightDatabase = new HashMap<>();
    public void addAirportToDatabase(DepartureCity departureCity){
        flightDatabase.put(departureCity.departureCity(), new ArrayList<>());
    }
    public void addFlightToDatabase(String departure, String arrival) throws AirportAlreadyExistsExecution {
        List<String> temporaryArrivalList = flightDatabase.get(departure);
        if (temporaryArrivalList.contains(arrival)){
            throw new AirportAlreadyExistsExecution();
        } else {
            temporaryArrivalList.add(arrival);
            flightDatabase.remove(departure);
            flightDatabase.put(departure,temporaryArrivalList);
        }
    }

    public Map<String, List<String>> getFlightDatabase() {
        return flightDatabase;
    }
}
