package com.example.task.service.impl;

import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.delivery.entity.Delivery;
import com.example.exception.CustomException;
import com.example.task.entity.Task;
import com.example.task.mapper.TaskMapper;
import com.example.task.service.TaskService;
import com.example.task.vo.TaskQueryCommand;
import com.example.task.vo.TaskQueryVO;
import com.example.task.vo.TaskSaveCommand;
import com.example.user.service.UserService;
import com.example.user.vo.UserQueryVO;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserService userService;

    @Override
    public void save(TaskSaveCommand saveCommand) {
        if (StringUtils.isBlank(saveCommand.getId())){
            // 保存
            addTask(saveCommand);
        }else {
            // 修改
            updateTask(saveCommand);
        }
    }

    private Boolean checkRole(TaskSaveCommand saveCommand){
        if (StringUtils.isNotBlank(saveCommand.getUserId())){
            UserQueryVO userQueryVO = userService.selectById(saveCommand.getUserId());
            if (Objects.equals(saveCommand.getType(), "0")){
                //入场 供应商
                return Objects.equals(userQueryVO.getRoleCode(), RoleEnum.VENDOR.name());
            }else {
                // 出场 客户
                return Objects.equals(userQueryVO.getRoleCode(), RoleEnum.CLIENT.name());
            }
        }
        return true;
    }


    @Override
    public void addTask(TaskSaveCommand saveCommand) {
        if (!this.checkRole(saveCommand)){
            throw new CustomException(ResultCodeEnum.ROLE_CODE_ERROR);
        }
        if (StringUtils.isBlank(saveCommand.getUnloadWarehouseId())){
            throw new CustomException(ResultCodeEnum.UNLOAD_NULL_ERROR);
        }

        Task task = new Task();
        BeanUtils.copyProperties(saveCommand,task);
        task.setId(UUIDUtil.get32UUID());
        task.setCreator(TokenUtils.getUserID());
        taskMapper.insert(task);
    }

    @Override
    public void updateTask(TaskSaveCommand saveCommand) {
        if (!this.checkRole(saveCommand)){
            throw new CustomException(ResultCodeEnum.ROLE_CODE_ERROR);
        }
        Task task = new Task();
        BeanUtils.copyProperties(saveCommand,task);
        task.setModifier(TokenUtils.getUserID());
        taskMapper.update(task);
    }

    @Override
    public int deleteTask(String id) {
        Map<String, Object> cond = new HashMap<>();
        cond.put("id", id);
        cond.put("modifier", TokenUtils.getUserID());
        return taskMapper.delete(cond);
    }

    private void updateStatus(String id, String status){
        Task task = new Task();
        task.setStatus(status);
        task.setId(id);
        task.setModifier(TokenUtils.getUserID());
        taskMapper.update(task);
    }

    public void auditTask(String taskId){
        Task task = taskMapper.selectById(taskId);
        if (!Objects.equals(task.getStatus(), "0")
                || StringUtils.isBlank(task.getEmbarkWarehouseId())
                || StringUtils.isBlank(task.getUnloadWarehouseId())){
            throw new CustomException(ResultCodeEnum.AUDIT_ERROR);
        }
        this.updateStatus(taskId, "1");
    }

    @Override
    public void startDeliver(String taskId){
        Task task = taskMapper.selectById(taskId);
        if (Objects.equals(task.getStatus(), "2")){
            return;
        }
        if (!Objects.equals(task.getStatus(), "1")){
            throw new CustomException(ResultCodeEnum.DELIVER_ERROR);
        }
        this.updateStatus(taskId, "2");
    }

    @Override
    public TaskQueryVO selectTask(String id) {
        Map<String, Object> cond = new HashMap<>();
        cond.put("id", id);
        return taskMapper.selectTask(cond);
    }

    @Override
    public List<TaskQueryVO> queryTask(TaskQueryCommand queryCommand) {
        Map<String, Object> cond = new HashMap<>();
        cond.put("type", queryCommand.getType());
        cond.put("status", queryCommand.getStatus());
        cond.put("siteId", queryCommand.getSiteId());
        cond.put("userId", queryCommand.getUserId());
        cond.put("freightId", queryCommand.getFreightId());
        return taskMapper.queryTasks(cond);
    }


}
