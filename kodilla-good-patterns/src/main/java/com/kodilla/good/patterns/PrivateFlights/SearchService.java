package com.kodilla.good.patterns.PrivateFlights;

import com.kodilla.good.patterns.PrivateFlights.exceptions.AirportDoesNotExistException;
import com.kodilla.good.patterns.PrivateFlights.exceptions.FlightNotPossibleException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchService {
    private FlightDataBase flightDataBase;
    public SearchService(FlightDataBase flightDataBase) {
        this.flightDataBase = flightDataBase;
    }
    public void showFlightsFromCity(String departureCity) throws AirportDoesNotExistException {
        boolean isAirportInMap = flightDataBase.getFlightDatabase().containsKey(departureCity);
        if (isAirportInMap){
            List<String> flightList = flightDataBase.getFlightDatabase().entrySet().stream()
                    .filter(n -> n.getKey().equals(departureCity))
                    .flatMap(n -> n.getValue().stream())
                    .collect(Collectors.toList());
            System.out.println(flightList);
        } else {
            throw new AirportDoesNotExistException();
        }
    }
    public void showFlightsToCity(String arrivalCity) throws AirportDoesNotExistException {
            List<String> flightList = flightDataBase.getFlightDatabase().entrySet().stream()
                    .filter(n -> n.getValue().contains(arrivalCity))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            if (flightList.size() > 0){
            System.out.println(flightList);
        } else {
            throw new AirportDoesNotExistException();
        }
    }
    public void showConnectingFlightsToCity(String departureCity, String arrivalCity) throws FlightNotPossibleException {
        List<String> arrivalCityListFromDepartureCity = flightDataBase.getFlightDatabase().entrySet().stream()
                .filter(n -> n.getKey().equals(departureCity))
                .flatMap(n -> n.getValue().stream())
                .collect(Collectors.toList());
        List<String> departureCityListFromArrivalCity = flightDataBase.getFlightDatabase().entrySet().stream()
                .filter(n -> n.getValue().contains(arrivalCity))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        arrivalCityListFromDepartureCity.retainAll(departureCityListFromArrivalCity);
        if (arrivalCityListFromDepartureCity.size() > 0){
            System.out.println("It is possible, you can flight there with connection in: " + arrivalCityListFromDepartureCity);
        } else {
            throw new FlightNotPossibleException();
        }
    }
}