package com.example.warehouse.mapper;

import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.vo.WarehouseQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WarehouseMapper {
    void insert(Warehouse warehouse);

    int update(Warehouse warehouse);

    int delete(Map<String, Object> cond);

    WarehouseQueryVO selectWarehouse(Map<String, Object> cond);

    List<WarehouseQueryVO> queryWarehouses(Map<String, Object> cond);
}
