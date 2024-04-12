package com.example.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="用户保存对象",description="用户对象user")
public class UserSaveCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("角色标识")
    private String  roleCode;

    @ApiModelProperty("站点")
    private String  siteId;

    @ApiModelProperty("状态（0：启用；1：禁用）")
    private String status;

    @ApiModelProperty("所属单位")
    private String unit;

    @ApiModelProperty("地址")
    private String address;
}
