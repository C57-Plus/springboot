package com.example.warehouse.entity;

import lombok.Data;

@Data
public class Warehouse {
    /**
     * 主键
     */
    private String id;

    /**
     * 仓库名
     */
    private String name;

    /**
     *
     */
    private String siteId;
    /**
     * 总容量
     */
    private String capacity;

    /**
     * 当前储量
     */
    private String currentCapacity;

    /**
     * 负责人
     */
    private String chargePerson;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    private String status;

    private String creator;

    private String modifier;
}
