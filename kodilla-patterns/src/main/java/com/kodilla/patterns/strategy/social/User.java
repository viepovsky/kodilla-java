package com.kodilla.patterns.strategy.social;

public class User {
    private final String nickName;
    protected SocialPublisher socialPublisher;
    public User (String nickName){
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public String sharePost(){
        return socialPublisher.share();
    }
    public void setSocialPublisher(SocialPublisher socialPublisher){
        this.socialPublisher = socialPublisher;
    }
}
