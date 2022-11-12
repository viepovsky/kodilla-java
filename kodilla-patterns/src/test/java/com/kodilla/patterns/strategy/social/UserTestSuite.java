package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("User Test Suite")
public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User user1 = new Millenials("User1");
        User user2 = new YGeneration("User2");
        User user3 = new ZGeneration("User3");
        //When
        String user1Social = user1.sharePost();
        System.out.println(user1.getNickName() + " " + user1Social);
        String user2Social = user2.sharePost();
        System.out.println(user2.getNickName() + " " + user2Social);
        String user3Social = user3.sharePost();
        System.out.println(user3.getNickName() + " " + user3Social);
        //Then
        assertEquals("[Facebook publisher]", user1Social);
        assertEquals("[Snapchat publisher]", user2Social);
        assertEquals("[Twitter publisher]", user3Social);
    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        User user = new Millenials("User1");
        //When
        user.setSocialPublisher(new TwitterPublisher());
        String userSocial =user.sharePost();
                //Then
        assertEquals("[Twitter publisher]", userSocial);
    }
}
