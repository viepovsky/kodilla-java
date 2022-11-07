package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TDD: Drawer Test Suite")
public class DrawerTestSuite {
    @Test
    public void testDoDrawingWithCircle(){
        //Given
        Drawer drawer = new Drawer(new Circle());
        //When
        String result = drawer.doDrawing();
        //Then
        assertEquals("This is a circle", result);
    }
    @Test
    public void testDoDrawingWithTriangle(){
        //Given
        Drawer drawer = new Drawer(new Triangle());
        //When
        String result = drawer.doDrawing();
        //Then
        assertEquals("This is a triangle", result);
    }
}
