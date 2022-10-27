package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private final int peopleQuantity;
    public Country(int peopleQuantity){
        this.peopleQuantity = peopleQuantity;
    }
    public BigDecimal getPeopleQuantity(){
        BigDecimal bigDecimal = new BigDecimal(peopleQuantity);
        return bigDecimal;
    }
}
