package com.kodilla.sudoku;

import com.kodilla.sudoku.Exceptions.DeletedLastPossibilityAndCannotInputValueException;
import com.kodilla.sudoku.Exceptions.OnlyOnePossibilityButThisValueIsAlreadyOnBoard;
import com.kodilla.sudoku.Exceptions.SameValuesOnBoardExistsException;

public class SudokuGameStarter {
    public static void main(String[] args) throws OnlyOnePossibilityButThisValueIsAlreadyOnBoard, SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException {
        SudokuGame sudokuGame = new SudokuGame();
        sudokuGame.resolveSudoku();
    }
}
