package com.example.vehicle.service;

import com.example.vehicle.vo.VehicleQueryCommand;
import com.example.vehicle.vo.VehicleQueryVO;
import com.example.vehicle.vo.VehicleSaveCommand;
import com.example.warehouse.vo.WarehouseQueryCommand;
import com.example.warehouse.vo.WarehouseQueryVO;
import com.example.warehouse.vo.WarehouseSaveCommand;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleSaveCommand saveCommand);

    void insertVehicle(VehicleSaveCommand saveCommand);

    int updateVehicle(VehicleSaveCommand saveCommand);

    int deleteVehicle(String id);

    VehicleQueryVO selectVehicle(VehicleQueryCommand queryCommand);

    List<VehicleQueryVO> queryVehicle(VehicleQueryCommand queryCommand);
}
