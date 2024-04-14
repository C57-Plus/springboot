package com.example.task.entity;

import lombok.Data;

@Data
public class Task {
    /**
     * 主键
     */
    private String id;

    /**
     * 类型（0：入场；1：出场）
     */
    private String type;

    /**
     * 状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成）
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
     * 关联用户Id（入场；供应商；出场：客户）
     */
    private String userId;

    /**
     * 货物ID
     */
    private String freightId;

    /**
     * 货物重量
     */
    private String weight;

    /**
     * 质检方式（0：无需质检；1：要质检）
     */
    private String inspectionMethod;

    /**
     * 过磅审核（0：否；1：是）
     */
    private String checkFlag;

    private String creator;

    private String modifier;
}
