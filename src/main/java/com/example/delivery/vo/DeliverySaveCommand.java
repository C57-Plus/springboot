package com.example.delivery.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="配送单保存",description="配送单保存Command")
public class DeliverySaveCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("类型（0：入场；1：出场）")
    private String type;

    @ApiModelProperty("状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成）")
    private String status;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("任务单ID")
    private String taskId;

    @ApiModelProperty("司机ID")
    private String driverId;

    @ApiModelProperty("车牌")
    private String plate;

    @ApiModelProperty("货物ID")
    private String freightId;

    @ApiModelProperty("计划量")
    private String plannedWeight;

    @ApiModelProperty("毛重")
    private String grossWeight;

    @ApiModelProperty("皮重")
    private String tare;

    @ApiModelProperty("扣除")
    private String deduct;

    @ApiModelProperty("净重（毛重-皮重-扣除）")
    private String netWeight;

    @ApiModelProperty("称重时间")
    private String weightingTime;

    @ApiModelProperty("装载仓库ID")
    private String embarkWarehouseId;

    @ApiModelProperty("卸货仓库ID")
    private String unloadWarehouseId;
}
