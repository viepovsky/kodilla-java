package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues;
    public SudokuElement(){
        value = EMPTY;
        possibleValues = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            possibleValues.add(i);
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return new ArrayList<>(possibleValues);
    }

    @Override
    public String toString() {
        if (value == EMPTY){
            return " ";
        } else {
            return String.valueOf(value);
        }
    }
}
