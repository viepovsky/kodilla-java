package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {
    private Statistics statistics;

    private int numberOfUsers;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;
    public StatisticsCalculator(Statistics statistics){
        this.statistics = statistics;
    }
    public void calculateAdvStatistics(Statistics statistics){
        this.numberOfUsers = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        if (statistics.usersNames().size() != 0 && statistics.postsCount() > 0) {
            this.averagePostsPerUser = (double) statistics.postsCount() / statistics.usersNames().size();
            this.averageCommentsPerUser = (double) statistics.commentsCount() / statistics.usersNames().size();
            this.averageCommentsPerPost = (double)statistics.commentsCount() / statistics.postsCount();
        } else {
            this.averageCommentsPerPost = 0;
            this.averagePostsPerUser = 0;
            this.averageCommentsPerUser = 0;
        }
    }
    public String showStatistics(){
        return "Calculated statistics are:\n" + "Number of users:" + numberOfUsers + ", quantity of posts:" + postsCount + " quantity of comments:" +
                commentsCount + ".\nAverage posts per user:" + averagePostsPerUser + ", average comments per user:" + averageCommentsPerUser +
                ", average comments per post:" + averageCommentsPerPost;
    }
    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
