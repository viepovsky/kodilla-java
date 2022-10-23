package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("TDD: Statistics Calculator Test Suite")
public class StatisticsCalculatorTestSuite {
    private static int testCounter = 0;
    private List<String> generateListOfNNames(int namesQuantity){
        List<String> namesList = new ArrayList<>();
        for (int i = 1; i <= namesQuantity; i++){
            namesList.add("Adam" + i);
        }
        return namesList;
    }
    @Mock
    private Statistics statisticsMock;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Start of tests");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("End of tests");
    }
    @BeforeEach
    public void beforeEach(){
        testCounter++;
        System.out.println("Starting test #" + testCounter);
        List<String> usersList = generateListOfNNames(10);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(100);
    }
    @AfterEach
    public void afterEach(){
        System.out.println("End of test #" + testCounter);
    }
    @Test
    public void testCalculateAdvStatistics0Posts(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, statisticsCalculator.getPostsCount());
        assertEquals(0, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());

    }
    @Test
    public void testCalculateAdvStatistics1000Posts(){
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(100, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(10, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0.1, statisticsCalculator.getAverageCommentsPerPost());
    }
    @Test
    public void testCalculateAdvStatistics0Comments(){
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, statisticsCalculator.getCommentsCount());
        assertEquals(10, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }
    @Test
    public void testCalculateAdvStatisticsCommentsMoreThanPosts(){
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(200);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(200, statisticsCalculator.getCommentsCount());
        assertEquals(10, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(20, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(2, statisticsCalculator.getAverageCommentsPerPost());
    }
    @Test
    public void testCalculateAdvStatisticsCommentsLessThanPosts(){
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(200);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(200, statisticsCalculator.getPostsCount());
        assertEquals(20, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(10, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0.5, statisticsCalculator.getAverageCommentsPerPost());
    }
    @Test
    public void testCalculateAdvStatistics0Users(){
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List<String> usersList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, statisticsCalculator.getNumberOfUsers());
        assertEquals(0, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }
    @Test
    public void testCalculateAdvStatistics100Users(){
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List<String> usersList = generateListOfNNames(100);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, statisticsCalculator.getNumberOfUsers());
        assertEquals(1, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(1, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(1, statisticsCalculator.getAverageCommentsPerPost());
        System.out.println(statisticsCalculator.showStatistics());
    }
}
