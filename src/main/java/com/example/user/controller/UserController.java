package com.example.user.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.user.service.UserService;
import com.example.user.vo.UserQueryCommand;
import com.example.user.vo.UserQueryVO;
import com.example.user.vo.UserSaveCommand;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户表前端操作接口
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody UserSaveCommand command){
        userService.saveUser(command);
        return Result.success();
    }

    @GetMapping("/createUserName")
     public Result createUserName(){
        String userName = userService.createUserName();
         return Result.success(userName);
     }

    /**
     * 删除
     */
    @GetMapping("/delete")
    public Result deleteById(@RequestParam String id) {
        userService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<String> ids) {
        userService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody UserSaveCommand command) {
        userService.updateUser(command);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable String id) {
        UserQueryVO user = userService.selectById(id);
        return Result.success(user);
    }

    /**
     * 查询所有
     */
    @PostMapping("/queryUsers")
    public Result queryUsers(@RequestBody UserQueryCommand command) {
        List<UserQueryVO> list = userService.selectAll(command);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/queryPage")
    public Result queryPage(UserQueryCommand command,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<UserQueryVO> page = userService.selectPage(command, pageNum, pageSize);
        return Result.success(page);
    }
}
