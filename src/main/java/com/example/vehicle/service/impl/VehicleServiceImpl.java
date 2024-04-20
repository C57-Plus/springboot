package com.example.vehicle.service.impl;

import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import com.example.vehicle.entity.Vehicle;
import com.example.vehicle.mapper.VehicleMapper;
import com.example.vehicle.service.VehicleService;
import com.example.vehicle.vo.VehicleQueryCommand;
import com.example.vehicle.vo.VehicleQueryVO;
import com.example.vehicle.vo.VehicleSaveCommand;
import com.example.warehouse.vo.WarehouseQueryVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public void saveVehicle(VehicleSaveCommand saveCommand) {
        if (StringUtils.isBlank(saveCommand.getId())){
            // 新增
            insertVehicle(saveCommand);
        }else {
            // 修改
            updateVehicle(saveCommand);
        }
    }

    @Override
    public void insertVehicle(VehicleSaveCommand saveCommand) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(saveCommand, vehicle);
        vehicle.setId(UUIDUtil.get32UUID());
        String userId = TokenUtils.getUserID();
        vehicle.setCreator(userId);
        vehicle.setModifier(userId);
        vehicleMapper.insert(vehicle);
    }

    @Override
    public int updateVehicle(VehicleSaveCommand saveCommand) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(saveCommand, vehicle);
        String userId = TokenUtils.getUserID();
        vehicle.setModifier(userId);
        return vehicleMapper.updateVehicle(vehicle);
    }

    @Override
    public int deleteVehicle(String id) {
        return vehicleMapper.deleteVehicle(id);
    }

    @Override
    public VehicleQueryVO selectVehicle(VehicleQueryCommand queryCommand) {
        Map<String, Object> cond = new HashMap<>(1);
        cond.put("id", queryCommand.getId());
        return vehicleMapper.selectVehicle(cond);
    }

    @Override
    public List<VehicleQueryVO> queryVehicle(VehicleQueryCommand queryCommand) {
        Map<String, Object> cond = new HashMap<>(5);
        cond.put("plate", queryCommand.getPlate());
        cond.put("status", queryCommand.getStatus());
        cond.put("owner", queryCommand.getOwner());
        cond.put("phone", queryCommand.getPhone());
        cond.put("siteId", queryCommand.getSiteId());
        return vehicleMapper.queryVehicles(cond);
    }
}
