package com.example.task.controller;

import com.example.common.Result;
import com.example.site.vo.SiteQueryCommand;
import com.example.site.vo.SiteQueryVO;
import com.example.task.service.TaskService;
import com.example.task.vo.TaskQueryCommand;
import com.example.task.vo.TaskQueryVO;
import com.example.task.vo.TaskSaveCommand;
import com.example.user.vo.UserQueryVO;
import com.example.user.vo.UserSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public Result saveTask(@RequestBody TaskSaveCommand command){
        taskService.save(command);
        return Result.success();
    }

    @GetMapping("/deleteTask")
    public Result deleteTask(@RequestParam String id) {
        taskService.deleteTask(id);
        return Result.success();
    }

    @GetMapping("/selectById")
    public Result selectById(@RequestParam String id) {
        TaskQueryVO taskQueryVO = taskService.selectTask(id);
        return Result.success(taskQueryVO);
    }

    @PostMapping("/queryTasks")
    public Result queryTasks(@RequestBody TaskQueryCommand command){
        List<TaskQueryVO> taskQueryVOS = taskService.queryTask(command);
        return Result.success(taskQueryVOS);
    }
}
