package com.example.task.vo;

import com.example.freight.vo.FreightQueryVO;
import com.example.site.vo.SiteQueryVO;
import com.example.user.vo.UserQueryVO;
import com.example.warehouse.vo.WarehouseQueryVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TaskQueryVO {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("类型（0：入场；1：出场）")
    private String type;

    @ApiModelProperty("状态（0：待审核；1：待配送；2：配送中；3：待确认；4：已完成）")
    private String status;

    @ApiModelProperty("站点xx")
    private SiteQueryVO siteInfo;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("关联用户信息（入场；供应商；出场：客户）")
    private UserQueryVO userInfo;

    @ApiModelProperty("货物信息")
    private FreightQueryVO freightInfo;

    @ApiModelProperty("货物重量")
    private String weight;

    @ApiModelProperty("质检方式（0：无需质检；1：要质检）")
    private String inspectionMethod;

    @ApiModelProperty("过磅审核（0：否；1：是）")
    private String checkFlag;

    @ApiModelProperty("装载仓库信息")
    private WarehouseQueryVO embarkWarehouseInfo;

    @ApiModelProperty("卸货仓库信息")
    private WarehouseQueryVO unloadWarehouseInfo;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("修改时间")
    private String modifiedTime;
}
