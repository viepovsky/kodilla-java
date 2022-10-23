package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("TDD: Weather Forecast Test Suite")
public class WeatherForecastTestSuite {
    public static int testCounter = 0;
    @Mock
    private Temperatures temperaturesMock; //ten kod od razu tworzy zmienna typu Temperatures o nazwie temperaturesMock którą możemy używać w testach
    @Mock
    private Map<String, Double> temperaturesMap;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Start of all tests");
        System.out.println("----------");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("End of all tests");
    }
    @BeforeEach
    public void beforeEach(){
        testCounter++;
        System.out.println("Starting test #" + testCounter);
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }
    @AfterEach
    public void afterEach(){
        System.out.println("End of test #" + testCounter);
        System.out.println("----------");
    }
    @DisplayName("This method changes temperatures values should result in getting same size of HashMap as input data")
    @Test
    void testCalculateForecastWithMock(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5, quantityOfSensors);
    }
    @DisplayName("Using method averageTemperature should result in getting average temperature from HashMap")
    @Test
    void testAverageTemperature(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double a = ((25.5 + 26.2 + 24.8 + 25.2 + 26.1) / 5.0) * 100; //pomnozenie razy 100 zeby zrobic z liczby 25.560000000000002 -->> 2556.0000000002
        double expectedResult = Math.round(a) / 100.0; //robimy z liczby 2556.000000002 --> 2556, nastepnie dzielimy przez 100 i wychodzi pozadana liczba 25.56
        //When
        double result = weatherForecast.averageTemperature();
        //Then
        assertEquals(expectedResult, result);
    }
    @DisplayName("Using method medianTemperature should result in getting median temperature from HashMap")
    @Test
    void testMedianTemperature(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double expectedResult = 25.5;
        //When
        double result = weatherForecast.medianTemperature();
        //Then
        assertEquals(expectedResult, result);
    }


}
