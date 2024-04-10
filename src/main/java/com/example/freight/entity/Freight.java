package com.example.freight.entity;

import lombok.Data;

@Data
public class Freight {
    /**
     * 主键
     */
    private String id;

    /**
     * 货物名
     */
    private String name;

    /**
     * 登记重量
     */
    private String weight;

    /**
     * 入场任务单号
     */
    private String taskId;

    /**
     * 供应商ID
     */
    private String vendorId;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    private String creator;

    private String modifier;
}
