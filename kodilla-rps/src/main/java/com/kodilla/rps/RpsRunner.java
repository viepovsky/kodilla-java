package com.kodilla.rps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RpsRunner {
    public static void main(String[] args) throws IOException {
        Rps rpsRunner = new Rps();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("----------");
        System.out.println("Starting new game RPS");
        System.out.println("----------");
        System.out.print("Insert your name: ");
        String name = reader.readLine();
        System.out.print("\nHow many rounds till win: ");
        int rounds = Integer.parseInt(reader.readLine());

        rpsRunner.rules();
        boolean end = false;
        boolean newGame = false;

        while(!end){
            if(newGame){
                rpsRunner = new Rps();
                System.out.println("----------");
                System.out.println("Starting new game RPS");
                System.out.println("----------");
                System.out.print("Insert your name: ");
                name = reader.readLine();
                System.out.print("\nHow many rounds till win: ");
                rounds = Integer.parseInt(reader.readLine());
                newGame = false;
            }
            boolean decisionMade = false;
            char playerDecision = '0'; //jak to zainicjowac bez niczego
            while(!decisionMade && !newGame && !end){
                playerDecision = rpsRunner.decisionOf5();
                decisionMade = rpsRunner.checkDecisionOfWeapon(playerDecision);
                end = rpsRunner.checkDecisionOfQuit(playerDecision);
                newGame = rpsRunner.checkDecisionOfNewGame(playerDecision);
            }
            char chosenWeapon = playerDecision;
            Weapons playerWeapon = rpsRunner.playerWeapon(chosenWeapon);
            Weapons computerWeapon = rpsRunner.computerRandomWeapon();
            char result = playerWeapon.fight(computerWeapon);
            rpsRunner.resultCheck(result, name, playerWeapon, computerWeapon);

            if(rpsRunner.getPlayerPoints() == rounds || rpsRunner.getComputerPoints() == rounds){
                rpsRunner.showResults(name);
                while(!end && !newGame){
                    playerDecision = rpsRunner.decisionOf2();
                    end = rpsRunner.checkDecisionOfQuit(playerDecision);
                    newGame = rpsRunner.checkDecisionOfNewGame(playerDecision);
                }
            }
        }
    }
}
