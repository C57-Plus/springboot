package com.example.role.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.role.service.RoleService;
import com.example.role.vo.RoleQueryVO;
import com.example.role.vo.RoleSaveCommand;
import com.example.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Result add(@RequestBody RoleSaveCommand command) {
        // 数据校验
        if (ObjectUtil.isEmpty(command.getName()) || ObjectUtil.isEmpty(command.getCode())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        roleService.addRole(command);
        return Result.success();
    }

    @PostMapping("/edit")
    public Result edit(@RequestBody RoleSaveCommand command) {
        // 数据校验
        if (ObjectUtil.isEmpty(command.getName()) || ObjectUtil.isEmpty(command.getCode())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        roleService.saveRole(command);
        return Result.success();
    }

    @PostMapping("/queryRoles")
    public Result queryRoles(@RequestBody RoleSaveCommand command){
        List<RoleQueryVO> roleQueryVOs = roleService.queryVOS(command);
        return Result.success(roleQueryVOs);
    }

    @GetMapping("/deleteRole")
    public Result deleteRole(@RequestParam String id){
        return Result.success(roleService.deleteRole(id));
    }

    @GetMapping("/selectRoles")
    public Result selectRoles(@RequestParam String params){
        RoleSaveCommand command = new RoleSaveCommand();
        command.setName(params);
        List<RoleQueryVO> roleQueryVOs = roleService.queryVOS(command);
        return Result.success(roleQueryVOs);
    }
}
