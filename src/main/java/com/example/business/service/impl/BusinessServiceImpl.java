package com.example.business.service.impl;

import com.example.business.entity.Account;
import com.example.business.service.BusinessService;
import com.example.common.enums.RoleEnum;
import com.example.user.service.UserService;
import com.example.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Value("${admin.name}")
    private String adminName;
    @Value("${admin.password}")
    private String adminPassword;

    @Resource
    private UserService userService;

    @Override
    public Account checkRole(Account account){
        if (Objects.equals(account.getUserName(), adminName)
                && Objects.equals(account.getPassword(), adminPassword)){
            // 系统管理员登录
            account.setRoleCode(RoleEnum.ADMIN.name());

            // 生成token
            String tokenData = "1" + "-" + RoleEnum.ADMIN.name();
            String token = TokenUtils.createToken(tokenData, account.getPassword());
            account.setToken(token);
            account.setId("1");
        }else {
            account = userService.login(account);
        }
        return account;
    }
}
