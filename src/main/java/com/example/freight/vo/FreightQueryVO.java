package com.example.freight.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FreightQueryVO {
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

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("修改时间")
    private String modifiedTime;


//    @ApiModelProperty("登记重量")
//    private String weight;
//
//    @ApiModelProperty("入场任务单号")
//    private String taskId;
//
//    @ApiModelProperty("供应商ID")
//    private String vendorId;
//
//    @ApiModelProperty("供应商名称")
//    private String vendorName;
//
//    @ApiModelProperty("地址")
//    private String address;
}
