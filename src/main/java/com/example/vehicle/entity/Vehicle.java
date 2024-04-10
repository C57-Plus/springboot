package com.example.vehicle.entity;

import lombok.Data;

@Data
public class Vehicle {
    /**
     *
     */
    private String id;

    /**
     * 车牌号
     */
    private String plate;

    /**
     * 载重
     */
    private String carryingCapacity;

    /**
     * 自重
     */
    private String tare;

    /**
     * 状态（0：空闲，1：配送中，2：检修）
     */
    private String status;

    /**
     * 车主
     */
    private String owner;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关联站点ID
     */
    private String siteId;

    private String creator;

    private String modifier;

}
