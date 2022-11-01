package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightChecker {
    public void findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Warsaw", true);
        flightMap.put("Posen", true);
        flightMap.put("Berlin", false);
        flightMap.put("Paris", true);
        flightMap.put("Rome", false);
        int a = flightMap.size();
        int b = 0;
        boolean flightFound = false;
        for (Map.Entry<String, Boolean> entry : flightMap.entrySet()){
            if (entry.getKey().equals(flight.getArrivalAirport())){
                if(entry.getValue()){
                    System.out.println("You can fly there");
                    flightFound = true;
                } else {
                    System.out.println("You cannot fly there");
                    flightFound = true;
                }
            }
            b++;
            if (b == a && !flightFound){
                throw new RouteNotFoundException("There is no flight to this city");
            }
        }
    }
}
