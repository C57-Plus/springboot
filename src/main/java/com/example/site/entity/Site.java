package com.example.site.entity;

import lombok.Data;

@Data
public class Site {
    /**
     * id
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    private String chargePerson;

    private String phone;

    private String address;

    private String picture;

    private String creator;

    private String modifier;

}
