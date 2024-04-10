package com.example.vehicle.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="车辆保存command",description="车辆保存command")
public class VehicleSaveCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("车牌")
    private String plate;

    @ApiModelProperty("载重")
    private String carryingCapacity;

    @ApiModelProperty("自重")
    private String tare;

    @ApiModelProperty("状态（0：空闲，1：配送中，2：检修）")
    private String status;

    @ApiModelProperty("车主")
    private String owner;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("关联站点ID")
    private String siteId;
}
