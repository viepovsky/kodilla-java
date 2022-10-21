package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> figureCollection = new ArrayList<>();
    public void addFigure(Shape shape){
        figureCollection.add(shape);
    }
    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (figureCollection.contains(shape)){
            figureCollection.remove(shape);
            result = true;
        }
            return result;
    }
    public Shape getFigure(int n){
        return figureCollection.get(n);
    }
    public String showFigures(){
        String figures = "";
        int i = 0;
        for (Shape list : figureCollection){
            if (i == 0){
                figures = String.valueOf(list);
            } else {
                figures = figures + " " + list;
            }
            i++;
        }
        return figures;
    }
    public int getFiguresQuantity(){
        return figureCollection.size();
    }
    public double getField(Shape shape){
        return shape.getField();
    }
}
