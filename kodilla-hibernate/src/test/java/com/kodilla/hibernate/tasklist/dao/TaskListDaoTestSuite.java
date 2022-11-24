package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Task List Dao Test Suite")
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Task list example description.";
    private static final String NAME = "List name #1";

    @Test
    void testFindByListName(){
        //Given
        TaskList taskList = new TaskList(NAME, DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);
        //Then
        assertEquals(1, readTaskLists.size());
        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }

}
