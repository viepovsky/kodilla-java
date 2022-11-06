package com.kodilla.good.patterns.challenges;

public class Customer {
    private final String username;
    private String adress;
    public Customer(String username, String adress) {
        this.username = username;
        this.adress = adress;
    }
    public String getUsername() {
        return username;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
}
