package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name;
    private double firstSideLength;
    private double heightOfFirstSide;

    public Triangle (String name, double firstSideLength, double heightOfFirstSide){
        this.name = name;
        this.firstSideLength = firstSideLength;
        this.heightOfFirstSide = heightOfFirstSide;
    }

    public String getShapeName() {
        return name;
    }
    public double getField() {
        return 0.5 * firstSideLength * heightOfFirstSide;
    }
    public String toString(){
        return name;
    }
}
