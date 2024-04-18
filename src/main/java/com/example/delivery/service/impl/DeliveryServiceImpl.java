package com.example.delivery.service.impl;

import com.example.common.enums.ResultCodeEnum;
import com.example.delivery.entity.Delivery;
import com.example.delivery.mapper.DeliveryMapper;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.vo.DeliveryQueryCommand;
import com.example.delivery.vo.DeliveryQueryVO;
import com.example.delivery.vo.DeliverySaveCommand;
import com.example.exception.CustomException;
import com.example.task.entity.Task;
import com.example.task.mapper.TaskMapper;
import com.example.task.service.TaskService;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskService taskService;

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

    public Delivery createDelivery(String taskId){
        Task task = taskMapper.selectById(taskId);
//        DeliveryQueryCommand queryCommand = new DeliveryQueryCommand();
//        queryCommand.setTaskId(taskId);
//        queryCommand.setType(task.getType());
//        List<DeliveryQueryVO> deliveryQueryVOS = deliveryService.queryDeliveries(queryCommand);
//        if (!deliveryQueryVOS.isEmpty()){
//            List<Float> plannedWeights = deliveryQueryVOS
//                    .stream()
//                    .map(DeliveryQueryVO :: getPlannedWeight)
//                    .map(Float::parseFloat)
//                    .collect(Collectors.toList());
//            Float totalWeight = new Float("0");
//            for (Float item:plannedWeights) {
//                totalWeight+=item;
//            }
//            if (totalWeight >= new Float(task.getWeight())){
//                throw new CustomException(ResultCodeEnum.NO_NEED_DELIVERY_ERROR);
//            }
//        }
        Delivery delivery = new Delivery();
        delivery.setType(task.getType());
        delivery.setEmbarkWarehouseId(task.getEmbarkWarehouseId());
        delivery.setUnloadWarehouseId(task.getUnloadWarehouseId());
        delivery.setFreightId(task.getFreightId());
        delivery.setSiteId(task.getSiteId());
        return delivery;
    }
    private void updateStatus(String id, String status){
        Delivery delivery = new Delivery();
        delivery.setStatus(status);
        delivery.setId(id);
        delivery.setModifier(TokenUtils.getUserID());
        deliveryMapper.update(delivery);
    }

    public void auditDelivery(String deliveryId){
        Delivery delivery = deliveryMapper.selectById(deliveryId);
        if (!Objects.equals(delivery.getStatus(), "0")
                ||StringUtils.isBlank(delivery.getPlate())
                ||StringUtils.isBlank(delivery.getDriverId())){
            throw new CustomException(ResultCodeEnum.AUDIT_ERROR);
        }
        this.updateStatus(deliveryId, "1");
    }

    public void startDeliver(String deliveryId){
        Delivery delivery = deliveryMapper.selectById(deliveryId);
        if (delivery == null){
            throw new CustomException(ResultCodeEnum.DELIVERY_NOT_EXIST);
        }
        if (!Objects.equals(delivery.getStatus(), "1")){
            throw new CustomException(ResultCodeEnum.DELIVER_ERROR);
        }
        this.updateStatus(deliveryId, "2");
        // 修改任务单状态
        try {
            taskService.startDeliver(delivery.getTaskId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
