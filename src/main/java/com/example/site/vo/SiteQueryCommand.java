package com.example.site.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="站点查询",description="站点查询Command")
public class SiteQueryCommand {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("站点名")
    private String name;


}
