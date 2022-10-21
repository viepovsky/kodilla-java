package com.kodilla.testing.collection.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {
    private static int testCounter = 0;
    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the begining of tests.");
    }
    @AfterAll
    public static void afterAllTests(){
        System.out.println("This is the end of testing.");
    }
    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    @DisplayName("Tests for posts")
    class TestPosts{
        @Test
        void testAddPost(){
            //Given
            ForumUser user = new ForumUser("viepovsky","Oskar");
            //When
            user.addPost("viepovsky","Hello everyone, I'm new here.");
            //Then
            Assertions.assertEquals(1,user.getPostsQuantity());
        }
        @Test
        void testGetPost(){
            //Given
            ForumUser forumUser = new ForumUser("viepovsky","Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.","viepovsky");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            ForumPost retrievedPost = forumUser.getPost(0);
            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }
        @Test
        void testRemovePostNotExisting(){
            //Given
            ForumUser forumUser = new ForumUser("viepovsky", "Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.","viepovsky");
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertFalse(result);
        }
        @Test
        void testRemovePost(){
            //Given
            ForumUser forumUser = new ForumUser("viepovsky", "Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.","viepovsky");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,forumUser.getPostsQuantity());
        }
    }
    @Nested
    @DisplayName("Tests for comments")
    class TestComments {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("viepovsky", "Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.", "viepovsky");
            //When
            forumUser.addComment(thePost, "viepovsky", "Thanks for all posts.");
            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("viepovsky", "Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.", "viepovsky");
            ForumComment theComment = new ForumComment(thePost, "Thanks for all posts.", "viepovsky");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
            //When
            ForumComment retrievedComment = forumUser.getComment(0);
            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("viepovsky", "Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.", "viepovsky");
            ForumComment theComment = new ForumComment(thePost, "Thanks for all posts.", "viepovsky");
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("viepovsky", "Oskar");
            ForumPost thePost = new ForumPost("Hello everyone, I'm new here.", "viepovsky");
            ForumComment theComment = new ForumComment(thePost, "Thanks for all posts.", "viepovsky");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}


