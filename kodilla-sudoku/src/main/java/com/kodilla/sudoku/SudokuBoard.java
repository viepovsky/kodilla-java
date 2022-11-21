package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> board;
    public SudokuBoard(){
        board = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            board.add(new SudokuRow());
        }
    }
    public boolean putValueOnBoard(int row, int column, int value){
        int actualValue = board.get(row-1).getValuesRow().get(column-1).getValue();
        if(actualValue == SudokuElement.EMPTY){
            board.get(row-1).getValuesRow().get(column-1).setValue(value);
            return true;
        } else {
            return false;
        }
    }

    public List<SudokuRow> getBoard() {
        return new ArrayList<>(board);
    }

    @Override
    public String toString() {
        String line = "";
        for (SudokuRow rows : board){
            line += rows.toString() + "\n";
        }
        return line;
    }
}
