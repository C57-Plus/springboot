package com.example.delivery.entity;

import lombok.Data;

@Data
public class Delivery {
    /**
     * 主键
     */
    private String id;

    /**
     * 任务单ID
     */
    private String taskId;

    /**
     * 类型（0：入场；1：出场）
     */
    private String type;

    /**
     * 状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成; 5: 已废弃）
     */
    private String status;

    /**
     * 站点ID
     */
    private String siteId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 司机ID
     */
    private String driverId;

    /**
     * 车牌
     */
    private String plate;

    /**
     * 货物ID
     */
    private String freightId;

    /**
     * 计划量
     */
    private String plannedWeight;

    /**
     * 毛重
     */
    private String grossWeight;

    /**
     * 皮重
     */
    private String tare;

    /**
     * 扣除
     */
    private String deduct;

    /**
     * 净重（毛重-皮重-扣除）
     */
    private String netWeight;

    /**
     * 称重时间
     */
    private String weightingTime;

    /**
     * 装载仓库ID
     */
    private String embarkWarehouseId;

    /**
     * 卸货仓库ID
     */
    private String unloadWarehouseId;

    private String creator;

    private String modifier;
}
