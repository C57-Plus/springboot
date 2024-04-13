package com.example.warehouse.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="仓库保存command",description="仓库保存command")
public class WarehouseSaveCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("仓库名")
    private String name;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("总容量")
    private String capacity;

    @ApiModelProperty("当前储量")
    private String currentCapacity;

    @ApiModelProperty("负责人")
    private String chargePerson;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态（0：启用；1：禁用）")
    private String status;
}
