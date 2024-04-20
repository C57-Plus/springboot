package com.example.delivery.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="配送单查询",description="配送单查询Command")
public class DeliveryQueryCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("类型（0：入场；1：出场）")
    private String type;

    @ApiModelProperty("任务单ID")
    private String taskId;

    @ApiModelProperty("状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成）")
    private String status;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("司机ID")
    private String driverId;

    @ApiModelProperty("车牌")
    private String plate;

    @ApiModelProperty("货物ID")
    private String freightId;
}
