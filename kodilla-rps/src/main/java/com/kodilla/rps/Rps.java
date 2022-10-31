package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public final class Rps {
    Scanner scanner = new Scanner(System.in);
    private Results gameResults = new Results();
    public Weapons computerRandomWeapon(){
        Random random = new Random();
        int randomWeapon = random.nextInt(3) + 1;
        if (randomWeapon == 1){
            return new Rock();
        } else if (randomWeapon == 2){
            return new Paper();
        } else {
            return new Scissors();
        }
    }
    public Weapons playerWeapon(char chosenWeapon){
        if (chosenWeapon == '1'){
            return new Rock();
        } else if (chosenWeapon == '2'){
            return new Paper();
        } else {
            return new Scissors();
        }
    }

    public void resultCheck(char result, String name, Weapons playerWeapon, Weapons computerWeapon){
        if (result == 'w'){
            gameResults.addPlayerPoint();
            System.out.print("Player " + name + " has chosen:" + playerWeapon.getWeaponName());
            System.out.println(". Computer has chosen:" + computerWeapon.getWeaponName() + ".");
            System.out.println("Player " + name + " won this round.");
            System.out.println("Actual score is: " + "player " + name + " points: " + gameResults.getPlayerPoints() + ", computer points: " + gameResults.getComputerPoints());
        } else if (result == 't') {
            System.out.print("Player " + name + " has chosen:" + playerWeapon.getWeaponName());
            System.out.println(". Computer has chosen:" + computerWeapon.getWeaponName() + ".");
            System.out.println("It is a tie this round!");
            System.out.println("Actual score is: " + "player " + name + " points: " + gameResults.getPlayerPoints() + ", computer points: " + gameResults.getComputerPoints());
        } else if (result == 'l'){
            gameResults.addComputerPoint();
            System.out.print("Player " + name + " has chosen:" + playerWeapon.getWeaponName());
            System.out.println(". Computer has chosen:" + computerWeapon.getWeaponName() + ".");
            System.out.println("Computer won this round.");
            System.out.println("Actual score is: " + "player " + name + " points: " + gameResults.getPlayerPoints() + ", computer points: " + gameResults.getComputerPoints());
        } else if (result == 'e') {
            System.out.println("There was an error the game should end right now!"); //do poprawienia
        }
    }
    public void rules(){
        System.out.println("\nKey 1 - you choose to play rock.");
        System.out.println("Key 2 - you choose to play paper.");
        System.out.println("Key 3 - you choose to play scissors.");
        System.out.println("Key x - end of the game.");
        System.out.println("Key n - new game");
    }
    public int getPlayerPoints(){
        return gameResults.getPlayerPoints();
    }
    public int getComputerPoints(){
        return gameResults.getComputerPoints();
    }
    public void showResults(String name){
        if (gameResults.getPlayerPoints() > gameResults.getComputerPoints()){
            System.out.println("End of game, player: " + name + " has won!");
            System.out.println("Final score is: " + "player " + name + " points: " + gameResults.getPlayerPoints() + ", computer points: " + gameResults.getComputerPoints());
        } else {
            System.out.println("End of game, player: " + name + " has lost!");
            System.out.println("Final score is: " + "player " + name + " points: " + gameResults.getPlayerPoints() + ", computer points: " + gameResults.getComputerPoints());
        }
    }
    public char decisionOf5(){
        boolean decision = false;
        char playerDecision = '5';
        while(!decision){
            System.out.print("\nPlease make your move: ");
            playerDecision = scanner.next().charAt(0);
            if (playerDecision == 'x'){
                decision = true;
            } else if (playerDecision == 'n') {
                decision = true;
            } else if (playerDecision == '1') {
                decision = true;
            } else if (playerDecision == '2') {
                decision = true;
            } else if (playerDecision == '3') {
                decision = true;
            }
        }
        return playerDecision;
    }
    public char decisionOf2(){
        boolean decision = false;
        char playerDecision = '5';
        while(!decision) {
            System.out.print("\nPlease choose if you want new game or exit: ");
            playerDecision = scanner.next().charAt(0);
            if (playerDecision == 'x') {
                decision = true;
            } else if (playerDecision == 'n') {
                decision = true;
            }
        }
        return playerDecision;
    }
    public boolean endGame(){
        while(true){
            System.out.print("Do you really want to end the game? ");
            char playerDecision = scanner.next().charAt(0);
            if (playerDecision == 'y'){
                return true;
            } else if (playerDecision == 'n'){
                return false;
            }
        }
    }
    public boolean newGame(){
        while(true){
            System.out.print("Do you really want to start new game? ");
            char playerDecision = scanner.next().charAt(0);
            if (playerDecision == 'y'){
                return true;
            } else if (playerDecision == 'n'){
                return false;
            }
        }
    }
    public boolean checkDecisionOfWeapon (char playerDecision){
        if (playerDecision == '1' || playerDecision == '2' || playerDecision == '3'){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkDecisionOfQuit (char playerDecision){
        if (playerDecision == 'x' ){
            return endGame();
        } else {
            return false;
        }
    }
    public boolean checkDecisionOfNewGame (char playerDecision){
        if (playerDecision == 'n' ){
            return newGame();
        } else {
            return false;
        }
    }
}
