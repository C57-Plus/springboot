package com.example.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="任务单查询",description="任务单查询Command")
public class TaskQueryCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("类型（0：入场；1：出场）")
    private String type;

    @ApiModelProperty("状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成）")
    private String status;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("关联用户Id（入场；供应商；出场：客户）")
    private String userId;

    @ApiModelProperty("货物ID")
    private String freightId;
}
