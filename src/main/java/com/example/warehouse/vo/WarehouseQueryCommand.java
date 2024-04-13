package com.example.warehouse.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="货物查询command",description="货物查询command")
public class WarehouseQueryCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("仓库名")
    private String name;

    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("负责人")
    private String chargePerson;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("状态（0：启用；1：禁用）")
    private String status;
}
