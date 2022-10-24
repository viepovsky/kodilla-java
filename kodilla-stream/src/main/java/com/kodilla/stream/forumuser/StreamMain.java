package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<String,ForumUser> theForumUserMap = forum.getList().stream()
                .filter(user -> user.getSex() == 'm')
                .filter(user -> user.getYearOfBirth() < 2003)
                .filter(user -> user.getPostsMade() >= 1)
                .collect(Collectors.toMap(ForumUser::getSignature, user -> user));
        System.out.println("Elements in map: " + theForumUserMap.size());
        theForumUserMap.entrySet().stream()
                .map(entry -> "The key:" + entry.getKey() + ", the value:" + entry.getValue())
                .forEach(System.out::println);
    }
}
