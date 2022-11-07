package com.kodilla.spring.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
@DisplayName("Library Test Suite")
public class LibraryTestSuite {
    @Autowired
    private Library library;
    @Test
    void testLoadFromDb() {
        //Given

        //When
        library.loadFromDb();
        //Then
    }
    @Test
    void testSaveToDb() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        //When
        library.saveToDb();

        //Then
        //do nothing
    }
}

