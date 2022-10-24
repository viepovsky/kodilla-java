package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final String signature;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private int postsMade;

    public ForumUser(final String signature, final String userName, final char sex, int year, int month, int day, int postsMade){
        this.signature = signature;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.postsMade = postsMade;
    }

    public String getSignature() {
        return signature;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public int getYearOfBirth() {
        return dateOfBirth.getYear();
    }

    public int getPostsMade() {
        return postsMade;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "signature='" + signature + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsMade=" + postsMade +
                '}';
    }
}
