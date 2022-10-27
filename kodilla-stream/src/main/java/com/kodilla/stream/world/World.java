package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> continentList = new ArrayList<>();
    public void addToContinentList(Continent continent){
        continentList.add(continent);
    }
    public BigDecimal getPeopleQuantity(){
        return continentList.stream()
                .flatMap(continent -> continent.getCountryList(continent).stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
