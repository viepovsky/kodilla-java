package com.kodilla.stream.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TDD: Array Operations Test Suite")
public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        //Given
        int[] numbersTable = {10, 20, 2, 30, 50};
        //When
        double result = getAverage(numbersTable);
        //Then
        double expectedResult = 22.4;
        assertEquals(expectedResult, result);
    }
}
