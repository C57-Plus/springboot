package com.example.vehicle.controller;

import com.example.common.Result;
import com.example.vehicle.service.VehicleService;
import com.example.vehicle.vo.VehicleQueryCommand;
import com.example.vehicle.vo.VehicleQueryVO;
import com.example.vehicle.vo.VehicleSaveCommand;
import com.example.warehouse.vo.WarehouseQueryCommand;
import com.example.warehouse.vo.WarehouseQueryVO;
import com.example.warehouse.vo.WarehouseSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public Result save(@RequestBody VehicleSaveCommand command){
        vehicleService.saveVehicle(command);
        return Result.success();
    }

    @PostMapping("/selectVehicle")
    public Result selectVehicle(@RequestBody VehicleQueryCommand command){
        VehicleQueryVO vehicleQueryVO = vehicleService.selectVehicle(command);
        return Result.success(vehicleQueryVO);
    }

    @PostMapping("/queryVehicles")
    public Result queryVehicles(@RequestBody VehicleQueryCommand command){
        List<VehicleQueryVO> vehicleQueryVOS = vehicleService.queryVehicle(command);
        return Result.success(vehicleQueryVOS);
    }

    @GetMapping("/deleteVehicle")
    public Result deleteVehicle(@RequestParam String id){
        return Result.success(vehicleService.deleteVehicle(id));
    }
}
