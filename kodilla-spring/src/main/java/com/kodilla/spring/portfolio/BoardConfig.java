package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Bean
    public Board board(){
        return new Board(getToDoList(),getInProgressList(),getDoneList());
    }
    @Bean
    public TaskList getToDoList(){
        return new TaskList();
    }
    @Bean
    public TaskList getInProgressList(){
        return new TaskList();
    }
    @Bean
    public TaskList getDoneList(){
        return new TaskList();
    }
}
