package com.kodilla.rps;

public class Results {
    private int playerPoints;
    private int computerPoints;
    public void addPlayerPoint(){
        playerPoints++;
    }
    public void addComputerPoint(){
        computerPoints++;
    }
    public int getPlayerPoints(){
        return playerPoints;
    }
    public int getComputerPoints(){
        return computerPoints;
    }
}
