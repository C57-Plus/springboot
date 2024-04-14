package com.example.task.mapper;

import com.example.task.entity.Task;
import com.example.task.vo.TaskQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    void insert(Task task);

    int update(Task task);

    int delete(Map<String, Object> cond);

    TaskQueryVO selectTask(Map<String, Object> cond);

    List<TaskQueryVO> queryTasks(Map<String, Object> cond);
}
