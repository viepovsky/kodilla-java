package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuInput {
    private final Scanner scanner = new Scanner(System.in);
    private final String possibleValues = "123456789";
    public String playerInputValues(){
        boolean endLoop = false;
        while (!endLoop){
            System.out.print("Your move [row(1-9),column(1-9),value(1-9)]:");
            String inputValue = scanner.nextLine();
            if (inputValue.length() >= 5){
                if (inputValue.equals("SUDOKU")){
                    return inputValue;
                }
                String column = String.valueOf(inputValue.charAt(0));
                String row = String.valueOf(inputValue.charAt(2));
                String value = String.valueOf(inputValue.charAt(4));
                if (possibleValues.contains(column) && possibleValues.contains(row) && possibleValues.contains(value)){
                    return inputValue;
                }
            }
        }
        return null;
    }
}
