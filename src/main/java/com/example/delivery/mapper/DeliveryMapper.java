package com.example.delivery.mapper;

import com.example.delivery.entity.Delivery;
import com.example.delivery.vo.DeliveryQueryVO;
import com.example.task.entity.Task;
import com.example.task.vo.TaskQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliveryMapper {
    void insert(Delivery delivery);

    int update(Delivery delivery);

    int delete(Map<String, Object> cond);

    DeliveryQueryVO selectDelivery(Map<String, Object> cond);

    List<DeliveryQueryVO> queryDeliveries(Map<String, Object> cond);
}
