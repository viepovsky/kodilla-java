package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TDD: Simple Invoice Test Suite")
public class SimpleInvoiceTestSuite {
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
    @AfterEach
    public void afterEach(){
        System.out.println("End of test #" + testCounter);
    }
    @Test
    void testGetValueToPay(){
        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28),2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));
        //Then
        assertEquals(108.975, invoice.getValueToPay(),0.001);
    }
}
