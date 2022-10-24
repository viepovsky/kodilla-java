package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();
    public Forum(){
        forumUserList.add(new ForumUser("01","Alex",'m',2000,10,5,10));
        forumUserList.add(new ForumUser("02","Beta",'f',2003,3,15,5));
        forumUserList.add(new ForumUser("03","Alpha",'f',1999,2,25,20));
        forumUserList.add(new ForumUser("04","Sel",'f',2006,2,22,1));
        forumUserList.add(new ForumUser("05","Hel",'m',2012,1,13,0));
        forumUserList.add(new ForumUser("06","Pele",'m',1990,9,10,4));
        forumUserList.add(new ForumUser("07","Alexa",'f',1996,11,5,13));
    }
    public List<ForumUser> getList(){
        return new ArrayList<>(forumUserList);
    }
}
