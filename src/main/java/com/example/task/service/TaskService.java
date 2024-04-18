package com.example.task.service;

import com.example.task.vo.TaskQueryCommand;
import com.example.task.vo.TaskQueryVO;
import com.example.task.vo.TaskSaveCommand;

import java.util.List;

public interface TaskService {
    void save(TaskSaveCommand saveCommand);

    void addTask(TaskSaveCommand saveCommand);

    void updateTask(TaskSaveCommand saveCommand);

    int deleteTask(String id);

    TaskQueryVO selectTask(String id);

    List<TaskQueryVO> queryTask(TaskQueryCommand queryCommand);

    void startDeliver(String taskId);
}
