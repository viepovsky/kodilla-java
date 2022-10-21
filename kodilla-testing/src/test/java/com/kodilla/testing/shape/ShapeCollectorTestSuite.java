package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {
    public static int testCounter = 0;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Start of all tests");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("End of all tests");
    }
    @BeforeEach
    public void beforeEach(){
        testCounter++;
        System.out.println("Starting test #" + testCounter);
    }
    @DisplayName("Adding new shape should result in getting same shape")
    @Test
    void testAddFigure(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        //When
        figureShape.addFigure(circle);
        //Then
        assertEquals(circle, figureShape.getFigure(0));
    }
    @DisplayName("Removing not existing shape should result in doing nothing")
    @Test
    void testRemoveFigureNotExisting(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        //When
        boolean result = figureShape.removeFigure(circle);
        //Then
        assertFalse(result);
    }
    @DisplayName("Removing shape should result in empty list size")
    @Test
    void testRemoveFigure(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        figureShape.addFigure(circle);
        //When
        boolean result = figureShape.removeFigure(circle);
        //Then
        assertTrue(result);
        assertEquals(0, figureShape.getFiguresQuantity());
    }
    @DisplayName("Getting figure should result in getting added figure")
    @Test
    void testGetFigure(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        figureShape.addFigure(circle);
        //When
        Shape retrievedFigure = figureShape.getFigure(0);
        //Then
        assertEquals(circle,retrievedFigure);

    }
    @DisplayName("Show figures should result in all figures in one String")
    @Test
    void testShowFiguresOneFigure(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        figureShape.addFigure(circle);
        String expectedFigures = "Circle";
        //When
        String retrievedFigures = figureShape.showFigures();
        //Then
        assertEquals(expectedFigures,retrievedFigures);
    }
    @DisplayName("Show figures should result in all figures in one String")
    @Test
    void testShowFiguresMultipleFigures(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        figureShape.addFigure(circle);
        Shape circle1 = new Circle("Circle",5.0);
        figureShape.addFigure(circle1);
        Shape square = new Square("Square",5.5);
        figureShape.addFigure(square);
        String expectedFigures = "Circle Circle Square";
        //When
        String retrievedFigures = figureShape.showFigures();
        //Then
        assertEquals(expectedFigures,retrievedFigures);
    }
    @DisplayName("Get field should result in getting the figures field")
    @Test
    void testGetField(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        figureShape.addFigure(circle);
        Double expectedValue = Math.PI * 6.0 * 6.0;
        //When
        double retrievedValue = figureShape.getField(circle);
        //Then
        assertEquals(expectedValue, retrievedValue);
    }
    @DisplayName("Figures quantity should result in getting collection size")
    @Test
    void testFiguresQuantity(){
        //Given
        ShapeCollector figureShape = new ShapeCollector();
        Shape circle = new Circle("Circle",6.0);
        //When
        figureShape.addFigure(circle);
        //Then
        assertEquals(1,figureShape.getFiguresQuantity());
    }

}
