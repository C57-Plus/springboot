package com.example.user.entity;

import com.example.business.entity.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User extends Account {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 角色标识
     */
    private String roleCode;

    /**
     * 站点ID
     */
    private String siteId;

    /**
     * 状态（0：启用；1：禁用）
     */
    private String status;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 电话
     */
    private String phone;

    /**
     * 所属单位
     */
    private String unit;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;
}
