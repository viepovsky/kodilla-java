package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Exception Handling Test Suite")
public class ExceptionHandlingTestSuite {
    @Test
    void testProbablyIWillThrowException(){
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //Then & When
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1,1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,2)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5,2)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,2))
                );
    }
}
