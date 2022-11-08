package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Board Test Suite")
public class BoardTestSuite {
    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().addTask("Task1");
        board.getInProgressList().addTask("Task2");
        board.getDoneList().addTask("Task3");
        //Then
        assertEquals(1,board.getToDoList().getTasks().size());
        assertEquals(1,board.getInProgressList().getTasks().size());
        assertEquals(1,board.getDoneList().getTasks().size());
        assertEquals("Task1",board.getToDoList().getTask(0));
        assertEquals("Task2",board.getInProgressList().getTask(0));
        assertEquals("Task3",board.getDoneList().getTask(0));
    }

}
