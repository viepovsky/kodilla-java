package com.kodilla.stream.world;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("TDD: World Test Suite")
public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity(){
        //Given
        Country Poland = new Country(40000000);
        Country Germany = new Country(80000000);
        Country France = new Country(70000000);
        Country Canada = new Country(40000000);
        Country USA = new Country(300000000);
        Country China = new Country(1400000000);
        Country Japan = new Country(120000000);
        Continent Europe = new Continent();
        Continent America = new Continent();
        Continent Asia = new Continent();
        Europe.addCountryToContinent(Poland);
        Europe.addCountryToContinent(Germany);
        Europe.addCountryToContinent(France);
        America.addCountryToContinent(Canada);
        America.addCountryToContinent(USA);
        Asia.addCountryToContinent(China);
        Asia.addCountryToContinent(Japan);
        World world = new World();
        world.addToContinentList(Europe);
        world.addToContinentList(America);
        world.addToContinentList(Asia);
        //When
        BigDecimal worldPeopleQuantity = world.getPeopleQuantity();
        //Then
        BigDecimal expectedQuantity = new BigDecimal("2050000000");
        assertEquals(expectedQuantity, worldPeopleQuantity);
    }
}
