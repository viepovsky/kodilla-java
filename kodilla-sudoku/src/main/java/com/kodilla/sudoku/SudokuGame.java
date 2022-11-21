package com.kodilla.sudoku;

import com.kodilla.sudoku.Exceptions.DeletedLastPossibilityAndCannotInputValueException;
import com.kodilla.sudoku.Exceptions.OnlyOnePossibilityButThisValueIsAlreadyOnBoard;
import com.kodilla.sudoku.Exceptions.SameValuesOnBoardExistsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuGame {
    private final SudokuBoard sudokuBoard;
    private final SudokuInput sudokuInput;
    private static boolean moveMadeThisIteration;
    private static int iterationsMade = 0;
    public SudokuGame() {
        sudokuBoard = new SudokuBoard();
        sudokuInput = new SudokuInput();
    }

    public boolean playerDecision(){
        boolean endLoop = false;
        while (!endLoop){
            String inputValue = sudokuInput.playerInputValues();
            boolean valueOrSolve = inputValue.equals("SUDOKU");
            if (!valueOrSolve){
                int column = Character.getNumericValue(inputValue.charAt(0));
                int row = Character.getNumericValue(inputValue.charAt(2));
                int value = Character.getNumericValue(inputValue.charAt(4));
                if (sudokuBoard.putValueOnBoard(column, row, value)){
                    System.out.println(sudokuBoard);
                    return false;
                }
            } else{
                return true;
            }
        }
        return false;
    }

    public void makePossibilityListsEmpty(){
        for (SudokuRow sudokuRow : sudokuBoard.getBoard()){
            for (SudokuElement sudokuElement : sudokuRow.getValuesRow()){
                if (sudokuElement.getValue() != SudokuElement.EMPTY) {
                    sudokuElement.setPossibleValues(Collections.emptyList());
                }
            }
        }
    }

    public void checkIfValuesDontExclude() throws SameValuesOnBoardExistsException {
        for (SudokuRow sudokuRow : sudokuBoard.getBoard()){
            List<Integer> onBoardValuesList = new ArrayList<>();
            for (SudokuElement sudokuElement : sudokuRow.getValuesRow()){
                if (sudokuElement.getValue() != SudokuElement.EMPTY){
                    if(onBoardValuesList.contains(sudokuElement.getValue())){
                        throw new SameValuesOnBoardExistsException();
                    } else {
                        onBoardValuesList.add(sudokuElement.getValue());
                    }
                }
            }
            for (int i = 0; i < 9; i++){
                onBoardValuesList.removeAll(onBoardValuesList);
                for (SudokuRow sudokuRowColumns : sudokuBoard.getBoard()) {
                    if (sudokuRowColumns.getValuesRow().get(i).getValue() != SudokuElement.EMPTY) {
                        if (onBoardValuesList.contains(sudokuRowColumns.getValuesRow().get(i).getValue())) {
                            throw new SameValuesOnBoardExistsException();
                        } else {
                            onBoardValuesList.add(sudokuRowColumns.getValuesRow().get(i).getValue());
                        }
                    }
                }
            }
        }
    }

    public void solveSudokuLines() throws OnlyOnePossibilityButThisValueIsAlreadyOnBoard, SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException {
        for (SudokuRow sudokuRow : sudokuBoard.getBoard()){
            for (SudokuElement sudokuElement : sudokuRow.getValuesRow()){
                if (sudokuElement.getValue() == SudokuElement.EMPTY){
                    List<Integer> possibleValuesList = sudokuElement.getPossibleValues();
                    List<Integer> onBoardValuesList = new ArrayList<>();
                    for (Integer possibleValue : sudokuElement.getPossibleValues()){
                        boolean only1Possibility = true;
                        for (SudokuElement sudokuElementToCompare : sudokuRow.getValuesRow()){
                            iterationsMade++;
                            int valueOnBoardToCompare = sudokuElementToCompare.getValue();
                            List<Integer> possibleValuesListToCompare = sudokuElementToCompare.getPossibleValues();
                            if (possibleValue == valueOnBoardToCompare){
                                if(onBoardValuesList.contains(valueOnBoardToCompare)){
                                    throw new SameValuesOnBoardExistsException();
                                } else if (possibleValuesList.size() == 1){
                                    throw new DeletedLastPossibilityAndCannotInputValueException();
                                } else {
                                    possibleValuesList.remove(Integer.valueOf(valueOnBoardToCompare));
                                    onBoardValuesList.add(valueOnBoardToCompare);
                                }
                            }
                            if (!sudokuElement.equals(sudokuElementToCompare) && (possibleValue == valueOnBoardToCompare || possibleValuesListToCompare.contains(possibleValue))){
                                only1Possibility = false;
                            }
                        }
                        if (only1Possibility){
                            sudokuElement.setValue(possibleValue);
                            sudokuElement.setPossibleValues(Collections.emptyList());
                            moveMadeThisIteration = true;
                            break;
                        }
                    }
                    if (possibleValuesList.size() == 1){
                        if(onBoardValuesList.contains(possibleValuesList.get(0))){
                            throw new OnlyOnePossibilityButThisValueIsAlreadyOnBoard();
                        } else {
                            sudokuElement.setValue(possibleValuesList.get(0));
                            sudokuElement.setPossibleValues(Collections.emptyList());
                            moveMadeThisIteration = true;
                        }
                    } else if (sudokuElement.getPossibleValues().size() != 0){
                        sudokuElement.setPossibleValues(possibleValuesList);
                    }
                }
            }
        }
    }

    public void solveSudokuColumns() throws OnlyOnePossibilityButThisValueIsAlreadyOnBoard, SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException {
        for (SudokuRow sudokuRow : sudokuBoard.getBoard()){
            for (int i = 0; i < 9; i++){
                List<SudokuElement> valuesRow = sudokuRow.getValuesRow();
                SudokuElement sudokuElement = valuesRow.get(i);
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    List<Integer> possibleValuesList = sudokuElement.getPossibleValues();
                    List<Integer> onBoardValuesList = new ArrayList<>();
                    for (Integer possibleValue : sudokuElement.getPossibleValues()) {
                        boolean only1Possibility = true;
                        for (SudokuRow sudokuRowToCompare : sudokuBoard.getBoard()) {
                            iterationsMade++;
                            SudokuElement sudokuElementToCompare = sudokuRowToCompare.getValuesRow().get(i);
                            int valueOnBoardToCompare = sudokuElementToCompare.getValue();
                            List<Integer> possibleValuesListToCompare = sudokuElementToCompare.getPossibleValues();
                            if (possibleValue == valueOnBoardToCompare) {
                                if(onBoardValuesList.contains(valueOnBoardToCompare)){
                                    throw new SameValuesOnBoardExistsException();
                                } else if (possibleValuesList.size() == 1){
                                    throw new DeletedLastPossibilityAndCannotInputValueException();
                                } else {
                                    possibleValuesList.remove(Integer.valueOf(valueOnBoardToCompare));
                                    onBoardValuesList.add(valueOnBoardToCompare);
                                }
                            }
                            if (!sudokuElement.equals(sudokuElementToCompare) && (possibleValue == valueOnBoardToCompare || possibleValuesListToCompare.contains(possibleValue))) {
                                only1Possibility = false;
                            }
                        }
                        if (only1Possibility) {
                            sudokuElement.setValue(possibleValue);
                            sudokuElement.setPossibleValues(Collections.emptyList());
                            moveMadeThisIteration = true;
                            break;
                        }
                    }
                    if (possibleValuesList.size() == 1) {
                        if (onBoardValuesList.contains(possibleValuesList.get(0))) {
                            throw new OnlyOnePossibilityButThisValueIsAlreadyOnBoard();
                        } else {
                            sudokuElement.setValue(possibleValuesList.get(0));
                            sudokuElement.setPossibleValues(Collections.emptyList());
                            moveMadeThisIteration = true;
                        }
                    } else if (sudokuElement.getPossibleValues().size() != 0){
                        sudokuElement.setPossibleValues(possibleValuesList);
                    }
                }
            }
        }
    }

    public void solveSudokuSquares() throws SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException, OnlyOnePossibilityButThisValueIsAlreadyOnBoard {
        for (int k = 0; k < 9; k+=3){
            for (int i = 0; i < 9; i+=3){
                for (int j = i; j < 3 + i; j++) {
                    SudokuRow sudokuRow = sudokuBoard.getBoard().get(j);
                    List<SudokuElement> valuesRow = sudokuRow.getValuesRow();
                    for (int l = k; l < 3 + k; l++){
                        SudokuElement sudokuElement = valuesRow.get(l);
                        if (sudokuElement.getValue() == SudokuElement.EMPTY){
                            List<Integer> possibleValuesList = sudokuElement.getPossibleValues();
                            List<Integer> onBoardValuesList = new ArrayList<>();
                            for (Integer possibleValue : sudokuElement.getPossibleValues()){
                                boolean only1Possibility = true;
                                        for (int j2 = i; j2 < 3 + i; j2++) {
                                            SudokuRow sudokuRowToCompare = sudokuBoard.getBoard().get(j2);
                                            for (int l2 = k; l2 < 3 + k; l2++) {
                                                iterationsMade++;
                                                SudokuElement sudokuElementToCompare = sudokuRowToCompare.getValuesRow().get(l2);
                                                int valueOnBoardToCompare = sudokuElementToCompare.getValue();
                                                List<Integer> possibleValuesListToCompare = sudokuElementToCompare.getPossibleValues();
                                                if (possibleValue == valueOnBoardToCompare) {
                                                    if(onBoardValuesList.contains(valueOnBoardToCompare)){
                                                        throw new SameValuesOnBoardExistsException();
                                                    } else if (possibleValuesList.size() == 1){
                                                        throw new DeletedLastPossibilityAndCannotInputValueException();
                                                    } else {
                                                        possibleValuesList.remove(Integer.valueOf(valueOnBoardToCompare));
                                                        onBoardValuesList.add(valueOnBoardToCompare);
                                                    }
                                                }
                                                if (!sudokuElement.equals(sudokuElementToCompare) && (possibleValue == valueOnBoardToCompare || possibleValuesListToCompare.contains(possibleValue))) {
                                                    only1Possibility = false;
                                                }
                                            }
                                        }
                                if (only1Possibility) {
                                    sudokuElement.setValue(possibleValue);
                                    sudokuElement.setPossibleValues(Collections.emptyList());
                                    moveMadeThisIteration = true;
                                    break;
                                }
                            }
                            if (possibleValuesList.size() == 1) {
                                if (onBoardValuesList.contains(possibleValuesList.get(0))) {
                                    throw new OnlyOnePossibilityButThisValueIsAlreadyOnBoard();
                                } else {
                                    sudokuElement.setValue(possibleValuesList.get(0));
                                    sudokuElement.setPossibleValues(Collections.emptyList());
                                    moveMadeThisIteration = true;
                                }
                            } else if (sudokuElement.getPossibleValues().size() != 0){
                                sudokuElement.setPossibleValues(possibleValuesList);
                            }
                        }
                    }
                }
            }
        }
    }

    public void guessProcess(){

    }

    public void solveSudoku() throws OnlyOnePossibilityButThisValueIsAlreadyOnBoard, SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException {
        boolean sudokuIsDone;
        do {
            moveMadeThisIteration = false;
            solveSudokuLines();
            solveSudokuColumns();
            solveSudokuSquares();
            sudokuIsDone = checkIfSudokuIsDone();
            if (sudokuIsDone){
                break;
            }
        } while (moveMadeThisIteration);
        if (!sudokuIsDone){
            guessProcess();
        }
    }

    public boolean checkIfSudokuIsDone() throws SameValuesOnBoardExistsException {
        boolean sudokuDone = true;
        checkIfValuesDontExclude();
        for (SudokuRow sudokuRow : sudokuBoard.getBoard()){
            for (SudokuElement sudokuElement : sudokuRow.getValuesRow()){
                if (sudokuElement.getValue() == SudokuElement.EMPTY){
                    sudokuDone = false;
                }
            }
        }
        return sudokuDone;
    }

    public void resolveSudoku() throws OnlyOnePossibilityButThisValueIsAlreadyOnBoard, SameValuesOnBoardExistsException, DeletedLastPossibilityAndCannotInputValueException {
        System.out.println(sudokuBoard);
        boolean endDecision = false;
        while (!endDecision){
            endDecision = playerDecision();
        }
        checkIfValuesDontExclude();
        makePossibilityListsEmpty();
        solveSudoku();
        System.out.println(sudokuBoard);
        System.out.println("Number of iterations made = " + iterationsMade);
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }
}
