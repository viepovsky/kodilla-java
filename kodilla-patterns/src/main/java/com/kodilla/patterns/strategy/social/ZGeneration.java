package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User{
    public ZGeneration (String nickName){
        super(nickName);
        this.socialPublisher = new TwitterPublisher();

    }
}
