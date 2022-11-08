package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Logger Test Suite")
public class LoggerTestSuite {
    private final static Logger logger = Logger.LOGGER;
    @Test
    void testGetLastLog(){
        //Given
        logger.log("here sample text");
        String expectedText = "here sample text";
        //When
        String resultText = logger.getLastLog();
        //Then
        assertEquals(expectedText, resultText);
    }

}
