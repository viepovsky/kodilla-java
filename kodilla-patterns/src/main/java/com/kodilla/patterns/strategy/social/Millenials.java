package com.kodilla.patterns.strategy.social;

public class Millenials extends User{
    public Millenials (String nickName){
        super(nickName);
        this.socialPublisher = new FacebookPublisher();
    }
}
