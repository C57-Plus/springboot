package com.example.business.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.business.service.BusinessService;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.business.entity.Account;
import com.example.admin.service.AdminService;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基础前端接口
 */
@RestController
public class WebController {

    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @Autowired
    private BusinessService businessService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("访问成功");
    }

    /**
     * 后台系统登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUserName()) || ObjectUtil.isEmpty(account.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        account = userService.login(account);

        return Result.success(account);
    }


    /**
     * 小程序登录
     */
    @PostMapping("/loginV2")
    public Result loginV2(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUserName()) || ObjectUtil.isEmpty(account.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        //


        if (RoleEnum.ADMIN.name().equals(account.getRoleCode())) {
            account = adminService.login(account);
        }
//        } else if (RoleEnum.BUSINESS.name().equals(account.getRole())) {
//
//        } else if (RoleEnum.USER.name().equals(account.getRole())) {
//            account = userService.login(account);
//        }
        return Result.success(account);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUserName()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRoleCode())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }

        // 只有司机、客户、供应商支持主动注册，站点管理员联系系统管理员分配
        if (RoleEnum.VENDOR.name().equals(account.getRoleCode())
                || RoleEnum.CLIENT.name().equals(account.getRoleCode())
                || RoleEnum.DRIVER.name().equals(account.getRoleCode())){
            userService.register(account);
        }


        return Result.success();
    }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUserName()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRoleCode())) {
            adminService.updatePassword(account);
        }
        return Result.success();
    }

}
