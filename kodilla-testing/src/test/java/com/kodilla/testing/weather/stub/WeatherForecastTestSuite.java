package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TDD: Weather Forecast Test Suite")
public class WeatherForecastTestSuite {
    @Test
    void testCalculateForecastWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5, quantityOfSensors);
    }
}
