package com.example.freight.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="货物保存command",description="货物保存command")
public class FreightSaveCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("货物名")
    private String name;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("类型（0:入场；1：出场）")
    private String type;

    @ApiModelProperty("状态（0：启用；1：禁用）")
    private String status;

    @ApiModelProperty("备注")
    private String remark;

//    @ApiModelProperty("登记重量")
//    private String weight;
//
//    @ApiModelProperty("入场任务单号")
//    private String taskId;
//
//    @ApiModelProperty("供应商ID")
//    private String vendorId;
//
//    @ApiModelProperty("地址")
//    private String address;


}
