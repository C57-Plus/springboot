package com.example.site.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="站点保存",description="站点保存Command")
public class SiteSaveCommand {
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
}
