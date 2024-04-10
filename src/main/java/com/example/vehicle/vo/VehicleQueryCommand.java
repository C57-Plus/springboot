package com.example.vehicle.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="车辆查询command",description="车辆查询command")
public class VehicleQueryCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("车牌")
    private String plate;

    @ApiModelProperty("状态（0：空闲，1：配送中，2：检修）")
    private String status;

    @ApiModelProperty("车主")
    private String owner;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("关联站点ID")
    private String siteId;
}
