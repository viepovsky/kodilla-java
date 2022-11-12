package com.kodilla.patterns.strategy.social;

public class YGeneration extends User{
    public YGeneration(String nickName) {
        super(nickName);
        this.socialPublisher = new SnapchatPublisher();

    }
}
