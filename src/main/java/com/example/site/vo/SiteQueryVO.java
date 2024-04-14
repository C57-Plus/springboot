package com.example.site.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SiteQueryVO {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("站点名")
    private String name;

    @ApiModelProperty("负责人")
    private String chargePerson;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("站点地址")
    private String address;

    @ApiModelProperty("图片")
    private String picture;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("修改时间")
    private String modifiedTime;
}
