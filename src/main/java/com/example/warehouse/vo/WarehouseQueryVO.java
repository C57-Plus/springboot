package com.example.warehouse.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WarehouseQueryVO {
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

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("修改时间")
    private String modifiedTime;
}
