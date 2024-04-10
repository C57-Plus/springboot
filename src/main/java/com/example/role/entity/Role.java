package com.example.role.entity;

import lombok.Data;

@Data
public class Role {

    /**
     * id
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 标识
     */
    private String code;

    private String creator;

    private String modifier;
}
