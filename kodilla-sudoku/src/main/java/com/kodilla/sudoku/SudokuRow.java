package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> valuesRow;
    public SudokuRow(){
        valuesRow = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            valuesRow.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getValuesRow() {
        return new ArrayList<>(valuesRow);
    }

    @Override
    public String toString() {
        String row = "";
        for (SudokuElement values : valuesRow){
            row += "|" + values.toString();
        }
        return row + "|";
    }
}
