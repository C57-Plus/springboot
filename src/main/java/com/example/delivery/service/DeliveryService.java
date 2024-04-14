package com.example.delivery.service;

import com.example.delivery.vo.DeliveryQueryCommand;
import com.example.delivery.vo.DeliveryQueryVO;
import com.example.delivery.vo.DeliverySaveCommand;
import com.example.task.vo.TaskQueryCommand;
import com.example.task.vo.TaskQueryVO;
import com.example.task.vo.TaskSaveCommand;

import java.util.List;

public interface DeliveryService {
    void save(DeliverySaveCommand saveCommand);

    void addDelivery(DeliverySaveCommand saveCommand);

    void updateDelivery(DeliverySaveCommand saveCommand);

    int delete(String id);

    DeliveryQueryVO selectDelivery(String id);

    List<DeliveryQueryVO> queryDeliveries(DeliveryQueryCommand queryCommand);
}
