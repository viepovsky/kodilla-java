package com.kodilla.exception.test;

public class FlightCheckerRunner {
    public static void main(String[] args) throws RouteNotFoundException {
        FlightChecker flightChecker = new FlightChecker();
        Flight flightToCheck = new Flight("Warsaw","Paris1");
        try{
            flightChecker.findFilght(flightToCheck);
        } catch (RouteNotFoundException e){
            System.out.println("We are sorry, but we do not provide flight to chosen city.");
        }
    }
}
