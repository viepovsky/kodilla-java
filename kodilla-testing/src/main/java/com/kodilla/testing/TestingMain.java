package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultAdd = calculator.add(5,10);
        int resultSubtract = calculator.subtract(23,9);
        if (resultAdd == 15 && resultSubtract == 14){
            System.out.println("testOK");
        }else {
            System.out.println("Error");
        }

    }
}
