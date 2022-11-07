package com.kodilla.good.patterns.PrivateFlights;

import com.kodilla.good.patterns.PrivateFlights.exceptions.AirportAlreadyExistsExecution;

public class FlightDataBaseRetriever {
    public FlightDataBase getFlightDatabase() throws AirportAlreadyExistsExecution {
        FlightDataBase flightDataBase = new FlightDataBase();
        flightDataBase.addAirportToDatabase(new DepartureCity("Cracow"));
        flightDataBase.addAirportToDatabase(new DepartureCity("Warsaw"));
        flightDataBase.addAirportToDatabase(new DepartureCity("Posen"));
        flightDataBase.addFlightToDatabase("Warsaw","Oslo");
        flightDataBase.addFlightToDatabase("Warsaw","Paris");
        flightDataBase.addFlightToDatabase("Warsaw","London");
        flightDataBase.addFlightToDatabase("Warsaw","Cracow");
        flightDataBase.addFlightToDatabase("Warsaw","Posen");
        flightDataBase.addFlightToDatabase("Cracow","Warsaw");
        flightDataBase.addFlightToDatabase("Cracow","Posen");
        flightDataBase.addFlightToDatabase("Cracow","New York");
        flightDataBase.addFlightToDatabase("Cracow","Tokyo");
        flightDataBase.addFlightToDatabase("Posen","Moscow");
        flightDataBase.addFlightToDatabase("Posen","Barcelona");
        flightDataBase.addFlightToDatabase("Posen","Madrid");
        flightDataBase.addFlightToDatabase("Posen","Rome");
        return flightDataBase;
    }
}
