package com.example.role.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="角色保存",description="角色保存user")
public class RoleSaveCommand {
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("角色名")
    private String name;
    @ApiModelProperty("角色标识")
    private String code;
}
