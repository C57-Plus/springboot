package com.example.role.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleQueryVO {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("角色标识")
    private String code;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("修改时间")
    private String modifiedTime;
}
