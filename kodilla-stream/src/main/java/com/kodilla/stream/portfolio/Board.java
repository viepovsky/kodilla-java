package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class Board {
    private final List<TaskList> taskList = new ArrayList<>();
    private final String name;

    public Board(String name) {
        this.name = name;
    }
    public void addTaskList(TaskList taskList){
        this.taskList.add(taskList);
    }
    public boolean removeTaskList(TaskList taskList){
        return this.taskList.remove(taskList);
    }
    public List<TaskList> getTaskList(){
        return new ArrayList<>(taskList);
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Board{" + "\n" +
                "name='" + name + '\'' + ",\n" +
                "taskLists=" + taskList + "\n" +
                '}';
    }
}
