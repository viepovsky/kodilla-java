package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Task Factory Test Suite")
public class TaskFactoryTestSuite {
    @Test
    void testFactoryShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        //Then
        assertEquals("ShoppingTask number 1",shoppingTask.getTaskName());
    }
    @Test
    void testExecuteFactoryShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        //When
        shoppingTask.executeTask();
        boolean result = shoppingTask.isTaskExecuted();
        //Then
        assertTrue(result);
    }
    @Test
    void testFactoryPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        //Then
        assertEquals("PaintingTask number 1",shoppingTask.getTaskName());
    }
    @Test
    void testExecuteFactoryPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        //When
        shoppingTask.executeTask();
        boolean result = shoppingTask.isTaskExecuted();
        //Then
        assertTrue(result);
    }
    @Test
    void testFactoryDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        //Then
        assertEquals("DrivingTask number 1",shoppingTask.getTaskName());
    }
    @Test
    void testExecuteFactoryDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        //When
        shoppingTask.executeTask();
        boolean result = shoppingTask.isTaskExecuted();
        //Then
        assertTrue(result);
    }
}
