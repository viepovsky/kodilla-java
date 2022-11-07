package com.kodilla.spring.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Calculator Test Suite")
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;
    @Test
    void testCalculations(){
        //Given
        //When
        double resultAdd = calculator.add(10,2);
        double resultSub = calculator.sub(10,2);
        double resultMul = calculator.mul(10,2);
        double resultDiv = calculator.div(10,2);
        //Then
        assertEquals(12,resultAdd);
        assertEquals(8,resultSub);
        assertEquals(20,resultMul);
        assertEquals(5,resultDiv);
    }
}
