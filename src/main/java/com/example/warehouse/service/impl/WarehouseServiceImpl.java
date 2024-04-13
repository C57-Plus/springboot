package com.example.warehouse.service.impl;

import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.mapper.WarehouseMapper;
import com.example.warehouse.service.WarehouseService;
import com.example.warehouse.vo.WarehouseQueryCommand;
import com.example.warehouse.vo.WarehouseQueryVO;
import com.example.warehouse.vo.WarehouseSaveCommand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public void saveWarehouse(WarehouseSaveCommand saveCommand) {
        if (StringUtils.isBlank(saveCommand.getId())){
            // 新增
            insertWarehouse(saveCommand);
        }else {
            // 修改
            updateWarehouse(saveCommand);
        }
    }

    @Override
    public void insertWarehouse(WarehouseSaveCommand saveCommand) {
        Warehouse warehouse = new Warehouse();
        BeanUtils.copyProperties(saveCommand, warehouse);
        warehouse.setId(UUIDUtil.get32UUID());
        String userId = TokenUtils.getUserID();
        warehouse.setCreator(userId);
        warehouse.setModifier(userId);
        warehouseMapper.insert(warehouse);
    }

    @Override
    public int updateWarehouse(WarehouseSaveCommand saveCommand) {
        Warehouse warehouse = new Warehouse();
        BeanUtils.copyProperties(saveCommand, warehouse);
        warehouse.setModifier(TokenUtils.getUserID());
        return warehouseMapper.update(warehouse);
    }

    @Override
    public int deleteWarehouse(String id) {
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("id", id);
        cond.put("modifier", TokenUtils.getUserID());
        return warehouseMapper.delete(cond);
    }

    @Override
    public WarehouseQueryVO selectWarehouse(WarehouseQueryCommand queryCommand) {
        Map<String, Object> cond = new HashMap<>(1);
        cond.put("id", queryCommand.getId());
        return warehouseMapper.selectWarehouse(cond);
    }

    @Override
    public List<WarehouseQueryVO> queryWarehouses(WarehouseQueryCommand queryCommand) {
        Map<String, Object> cond = new HashMap<>(6);
        cond.put("name", queryCommand.getName());
        cond.put("chargePerson", queryCommand.getChargePerson());
        cond.put("address", queryCommand.getAddress());
        cond.put("phone", queryCommand.getPhone());
        cond.put("siteId", queryCommand.getSiteId());
        cond.put("status", queryCommand.getStatus());
        return warehouseMapper.queryWarehouses(cond);
    }
}
