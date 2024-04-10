package com.example.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="用户查询command",description="用户查询command")
public class UserQueryCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("所属单位")
    private String unit;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("角色标识")
    private String  roleCode;

    @ApiModelProperty("站点")
    private String  siteId;

    @ApiModelProperty("状态（0：启用；1：禁用）")
    private String status;
}
