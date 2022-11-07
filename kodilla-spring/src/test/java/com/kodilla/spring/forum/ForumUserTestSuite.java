package com.kodilla.spring.forum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("TDD: Forum User Test Suite with Spring Framework")
public class ForumUserTestSuite {
    @Test
    public void testGetUsername(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        //When
        ForumUser forumUser = context.getBean(ForumUser.class);
        String userName = forumUser.getUsername();
        //Then
        assertEquals("John Smith", userName);

    }
}
