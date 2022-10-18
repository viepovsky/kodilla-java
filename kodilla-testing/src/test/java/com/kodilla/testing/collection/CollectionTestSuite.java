package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test suite: begin");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Test suite: end");
    }
    @BeforeEach
    public void before(){
        System.out.println("Test case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test case: end");
    }
    @DisplayName("When created empty list, then exterminate should return empty list")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Arrays.asList();
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(emptyList);
        //Then
        Assertions.assertTrue(( resultList.size() == 0));
    }
    @DisplayName("When created list with numbers, then exterminate should return only odd numbers")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> fullList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            fullList.add(i);
        }
        Integer[] oddNumbers = {0, 2, 4, 6, 8};
        List<Integer> expectedResultList = Arrays.asList(oddNumbers);
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(fullList);
        System.out.println("Testing " + resultList);
        //Then
        Assertions.assertEquals(expectedResultList, resultList);
    }
}
