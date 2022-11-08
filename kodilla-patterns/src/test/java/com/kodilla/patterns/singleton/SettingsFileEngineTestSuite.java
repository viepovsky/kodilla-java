package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test Suite")
public class SettingsFileEngineTestSuite {
    private static final SettingsFileEngine settingsFileEngine = SettingsFileEngine.INSTANCE;;

    @BeforeAll
    public static void openSettingsFile() {
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingsFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFileName() {
        //Given
        //When
        String fileName = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileName);
        //Then
        assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        //Given
        //When
        boolean result = settingsFileEngine.loadSettings();
        //Then
        assertTrue(result);
    }

    @Test
    void testSaveSettings() {
        //Given
        //When
        boolean result = settingsFileEngine.saveSettings();
        //Then
        assertTrue(result);
    }
}
