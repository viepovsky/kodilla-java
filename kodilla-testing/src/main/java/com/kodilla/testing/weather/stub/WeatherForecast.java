package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }
    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double averageTemperature(){
        double temporaryValue = 0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            temporaryValue = temporaryValue + temperature.getValue();
        }
        return temporaryValue / temperatures.getTemperatures().size();
    }

    public double medianTemperature(){
        List<Double> list = new ArrayList<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            list.add(temperature.getValue());
        }
        Collections.sort(list);
        int value = 0;
        if (list.size() % 2 == 0){
            value = list.size()/2;
            return (list.get(value-1) + list.get(value))/2;
        } else {
            value = list.size()/2;
            return list.get(value);
        }
    }
}