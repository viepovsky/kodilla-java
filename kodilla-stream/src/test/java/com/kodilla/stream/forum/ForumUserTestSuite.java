package com.kodilla.stream.forum;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Forum User Test Suite")
public class ForumUserTestSuite {
    private static int testCounter = 0;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Start of all tests");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("End of all test");
    }
    @BeforeEach
    public void beforeEach(){
        testCounter++;
        System.out.println("Starting test #" + testCounter);
    }
    @AfterEach
    public void afterEach(){
        System.out.println("End of test #" + testCounter);
    }
    @Test
    public void testGetLocationsOfFriends(){
        //Given
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");
        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Create relations for user10
        user10.addFriend(user1);
        //Create relations for user2
        user2.addFriend(user3);
        //Create relations for user9
        user9.addFriend(user3);
        //Then
        assertEquals(3,user1.getLocationOfFriends().size());
        assertTrue(user1.getLocationOfFriends().contains("Key West"));
        assertTrue(user1.getLocationOfFriends().contains("Washington"));
        assertTrue(user1.getLocationOfFriends().contains("Miami"));
        assertFalse(user1.getLocationOfFriends().contains("Orlando"));
    }

    @Test
    public void testGetLocationsOfFriendsOfFriends(){
        //Given
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Konin");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");
        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Create relations for user10
        user10.addFriend(user1);
        //Create relations for user2
        user2.addFriend(user3);
        //Create relations for user9
        user9.addFriend(user3);
        //Then
        assertEquals(4,user1.getLocationsOfFriendsOfFriends().size());
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Key West"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Konin"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Miami"));
        assertFalse(user1.getLocationsOfFriendsOfFriends().contains("Orlando"));
    }

}
