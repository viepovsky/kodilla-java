package com.kodilla.sudoku;

import com.kodilla.sudoku.Exceptions.DeletedLastPossibilityAndCannotInputValueException;
import com.kodilla.sudoku.Exceptions.OnlyOnePossibilityButThisValueIsAlreadyOnBoard;
import com.kodilla.sudoku.Exceptions.SameValuesOnBoardExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sudoku Game Test Suite")
public class SudokuGameTestSuite {
    private SudokuGame sudokuGame = new SudokuGame();

    @BeforeEach
    void addValuesOnBoard(){
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 2, 9);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 3, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 5, 7);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 6, 8);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 7, 3);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 8, 4);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 9, 2);
        sudokuGame.getSudokuBoard().putValueOnBoard(2, 5, 4);
        sudokuGame.getSudokuBoard().putValueOnBoard(2, 6, 1);
        sudokuGame.getSudokuBoard().putValueOnBoard(2, 8, 6);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 1, 4);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 2, 6);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 3, 7);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 5, 3);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 6, 9);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 7, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(3, 9, 1);
        sudokuGame.getSudokuBoard().putValueOnBoard(4, 2, 8);
        sudokuGame.getSudokuBoard().putValueOnBoard(4, 4, 4);
        sudokuGame.getSudokuBoard().putValueOnBoard(5, 1, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(5, 3, 6);
        sudokuGame.getSudokuBoard().putValueOnBoard(5, 7, 2);
        sudokuGame.getSudokuBoard().putValueOnBoard(5, 8, 9);
        sudokuGame.getSudokuBoard().putValueOnBoard(6, 5, 9);
        sudokuGame.getSudokuBoard().putValueOnBoard(6, 7, 8);
        sudokuGame.getSudokuBoard().putValueOnBoard(6, 9, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(7, 1, 8);
        sudokuGame.getSudokuBoard().putValueOnBoard(7, 3, 4);
        sudokuGame.getSudokuBoard().putValueOnBoard(7, 4, 9);
        sudokuGame.getSudokuBoard().putValueOnBoard(7, 9, 3);
        sudokuGame.getSudokuBoard().putValueOnBoard(8, 5, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(8, 8, 2);
        sudokuGame.getSudokuBoard().putValueOnBoard(9, 2, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(9, 3, 1);
        sudokuGame.getSudokuBoard().putValueOnBoard(9, 4, 3);
        sudokuGame.getSudokuBoard().putValueOnBoard(9, 5, 6);
    }
    @DisplayName("Test putting values on board should result in same number of taken fields")
    @Test
    void testSudokuInputOnBoard(){
        //Given
        SudokuGame sudokuGame = new SudokuGame();

        sudokuGame.getSudokuBoard().putValueOnBoard(1, 2, 9);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 3, 5);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 5, 7);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 6, 8);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 7, 3);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 8, 4);
        sudokuGame.getSudokuBoard().putValueOnBoard(1, 9, 2);
        //When
        int boardValuesQuantity = 0;
        for (SudokuRow sudokuRow : sudokuGame.getSudokuBoard().getBoard()){
            for (SudokuElement sudokuElement : sudokuRow.getValuesRow()){
                if (sudokuElement.getValue() != SudokuElement.EMPTY){
                    boardValuesQuantity++;
                }
            }
        }
        //Then
        assertEquals(7,boardValuesQuantity);
    }
    @DisplayName("Test solving sudoku with given input should result in solving whole sudoku")
    @Test
    void testSudokuSolve() throws OnlyOnePossibilityButThisValueIsAlreadyOnBoard, SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException {
        //Given
        System.out.println(sudokuGame.getSudokuBoard());
        sudokuGame.makePossibilityListsEmpty();
        //When
        sudokuGame.solveSudoku();
        sudokuGame.checkIfValuesDontExclude();
        boolean sudokuDone = sudokuGame.checkIfSudokuIsDone();
        System.out.println(sudokuGame.getSudokuBoard());
        //Then
        assertTrue(sudokuDone);
    }
}
