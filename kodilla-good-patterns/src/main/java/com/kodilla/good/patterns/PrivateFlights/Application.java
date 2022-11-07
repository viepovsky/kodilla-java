package com.kodilla.good.patterns.PrivateFlights;

import com.kodilla.good.patterns.PrivateFlights.exceptions.AirportAlreadyExistsExecution;
import com.kodilla.good.patterns.PrivateFlights.exceptions.AirportDoesNotExistException;
import com.kodilla.good.patterns.PrivateFlights.exceptions.FlightNotPossibleException;

public class Application {
    public static void main(String[] args) throws AirportAlreadyExistsExecution, AirportDoesNotExistException, FlightNotPossibleException {
        FlightDataBaseRetriever flightDataBaseRetriever = new FlightDataBaseRetriever();
        FlightDataBase flightDataBase = flightDataBaseRetriever.getFlightDatabase();
        SearchService searchService = new SearchService(flightDataBase);
        searchService.showFlightsFromCity("Warsaw");
        searchService.showFlightsToCity("Posen");
        searchService.showConnectingFlightsToCity("Warsaw","Rome");
    }
}
