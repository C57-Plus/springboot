package com.example.vehicle.mapper;

import com.example.vehicle.entity.Vehicle;
import com.example.vehicle.vo.VehicleQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VehicleMapper {
    void insert(Vehicle vehicle);

    int updateVehicle(Vehicle vehicle);

    int deleteVehicle(String id);

    VehicleQueryVO selectVehicle(Map<String, Object> cond);

    List<VehicleQueryVO> queryVehicles(Map<String, Object> cond);
}
