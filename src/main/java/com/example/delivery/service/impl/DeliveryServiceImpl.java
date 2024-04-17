package com.example.delivery.service.impl;

import com.example.delivery.entity.Delivery;
import com.example.delivery.mapper.DeliveryMapper;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.vo.DeliveryQueryCommand;
import com.example.delivery.vo.DeliveryQueryVO;
import com.example.delivery.vo.DeliverySaveCommand;
import com.example.task.entity.Task;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public void save(DeliverySaveCommand saveCommand) {
        if (StringUtils.isBlank(saveCommand.getId())){
            // 保存
            addDelivery(saveCommand);
        }else {
            // 修改
            updateDelivery(saveCommand);
        }
    }

    @Override
    public void addDelivery(DeliverySaveCommand saveCommand) {
        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(saveCommand,delivery);
        delivery.setId(UUIDUtil.get32UUID());
        delivery.setCreator(TokenUtils.getUserID());
        deliveryMapper.insert(delivery);
    }

    @Override
    public void updateDelivery(DeliverySaveCommand saveCommand) {
        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(saveCommand,delivery);
        delivery.setModifier(TokenUtils.getUserID());
        deliveryMapper.update(delivery);
    }

    @Override
    public int delete(String id) {
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("id", id);
        cond.put("modifier", TokenUtils.getUserID());
        return deliveryMapper.delete(cond);
    }

    @Override
    public DeliveryQueryVO selectDelivery(String id) {
        Map<String, Object> cond = new HashMap<>(1);
        cond.put("id", id);
        return deliveryMapper.selectDelivery(cond);
    }

    @Override
    public List<DeliveryQueryVO> queryDeliveries(DeliveryQueryCommand queryCommand) {
        Map<String, Object> cond = new HashMap<>(7);
        cond.put("type", queryCommand.getType());
        cond.put("status", queryCommand.getStatus());
        cond.put("siteId", queryCommand.getSiteId());
        cond.put("driverId", queryCommand.getDriverId());
        cond.put("plate", queryCommand.getPlate());
        cond.put("freightId", queryCommand.getFreightId());
        cond.put("taskId", queryCommand.getTaskId());
        return deliveryMapper.queryDeliveries(cond);
    }
}
