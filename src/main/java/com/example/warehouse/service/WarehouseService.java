package com.example.warehouse.service;

import com.example.warehouse.vo.WarehouseQueryCommand;
import com.example.warehouse.vo.WarehouseQueryVO;
import com.example.warehouse.vo.WarehouseSaveCommand;

import java.util.List;

public interface WarehouseService {
    void saveWarehouse(WarehouseSaveCommand saveCommand);

    void insertWarehouse(WarehouseSaveCommand saveCommand);

    int updateWarehouse(WarehouseSaveCommand saveCommand);

    int deleteWarehouse(String id);

    WarehouseQueryVO selectWarehouse(WarehouseQueryCommand queryCommand);

    List<WarehouseQueryVO> queryWarehouses(WarehouseQueryCommand queryCommand);
}
