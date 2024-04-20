package com.example.delivery.vo;

import com.example.freight.vo.FreightQueryVO;
import com.example.site.vo.SiteQueryVO;
import com.example.user.vo.UserQueryVO;
import com.example.vehicle.vo.VehicleQueryVO;
import com.example.warehouse.vo.WarehouseQueryVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeliveryQueryVO {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("任务单ID")
    private String taskId;

    @ApiModelProperty("类型（0：入场；1：出场）")
    private String type;

    @ApiModelProperty("状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成）")
    private String status;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("司机信息")
    private UserQueryVO driverInfo;

    @ApiModelProperty("车牌号")
    private String plate;

    @ApiModelProperty("货物信息")
    private FreightQueryVO freightInfo;

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

    @ApiModelProperty("装载仓库信息")
    private WarehouseQueryVO embarkWarehouseInfo;

    @ApiModelProperty("卸货仓库信息")
    private WarehouseQueryVO unloadWarehouseInfo;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("修改时间")
    private String modifiedTime;
}
