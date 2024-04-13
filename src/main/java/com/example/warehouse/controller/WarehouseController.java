package com.example.warehouse.controller;

import com.example.common.Result;
import com.example.freight.vo.FreightQueryCommand;
import com.example.freight.vo.FreightQueryVO;
import com.example.freight.vo.FreightSaveCommand;
import com.example.warehouse.service.WarehouseService;
import com.example.warehouse.vo.WarehouseQueryCommand;
import com.example.warehouse.vo.WarehouseQueryVO;
import com.example.warehouse.vo.WarehouseSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/save")
    public Result save(@RequestBody WarehouseSaveCommand command){
        warehouseService.saveWarehouse(command);
        return Result.success();
    }

    @PostMapping("/selectWarehouse")
    public Result selectWarehouse(@RequestBody WarehouseQueryCommand command){
        WarehouseQueryVO warehouseQueryVO = warehouseService.selectWarehouse(command);
        return Result.success(warehouseQueryVO);
    }

    @PostMapping("/queryWarehouses")
    public Result queryWarehouses(@RequestBody WarehouseQueryCommand command){
        List<WarehouseQueryVO> warehouseQueryVOS = warehouseService.queryWarehouses(command);
        return Result.success(warehouseQueryVOS);
    }

    @GetMapping("/deleteWarehouse")
    public Result deleteWarehouse(@RequestParam String id){
        return Result.success(warehouseService.deleteWarehouse(id));
    }
}
