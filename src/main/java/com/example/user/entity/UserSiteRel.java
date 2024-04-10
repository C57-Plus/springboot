package com.example.user.entity;

import lombok.Data;

@Data
public class UserSiteRel {
    /**
     * 主键
     */
    private String id;

    /**
     * 站点ID
     */
    private String siteId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;
}
