package com.kodilla.testing.shape;

public class Square implements Shape {
    private String name;
    private double sideLength;

    public Square (String name, double sideLength){
        this.name = name;
        this.sideLength = sideLength;
    }

    public String getShapeName() {
        return name;
    }
    public double getField() {
        return sideLength * sideLength;
    }
    public String toString(){
        return name;
    }
}
