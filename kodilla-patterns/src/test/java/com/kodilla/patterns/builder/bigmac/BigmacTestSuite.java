package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Bigmac Test Suite")
public class BigmacTestSuite {
    @Test
    void testBigmacNew(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bigmac.BigmacBuilder.BUN_WITH_SESAME)
                .burgers(3)
                .sauce(Bigmac.BigmacBuilder.SAUCE_1000ISLANDS)
                .ingredients(Bigmac.BigmacBuilder.INGREDIENTS_CUCUMBER)
                .ingredients(Bigmac.BigmacBuilder.INGREDIENTS_CHEESE)
                .ingredients(Bigmac.BigmacBuilder.INGREDIENTS_LETTUCE)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(3, howManyIngredients);
    }
}
