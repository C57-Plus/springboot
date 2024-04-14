package com.example.delivery.controller;

import com.example.common.Result;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.vo.DeliveryQueryCommand;
import com.example.delivery.vo.DeliveryQueryVO;
import com.example.delivery.vo.DeliverySaveCommand;
import com.example.task.service.TaskService;
import com.example.task.vo.TaskQueryCommand;
import com.example.task.vo.TaskQueryVO;
import com.example.task.vo.TaskSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/save")
    public Result saveDelivery(@RequestBody DeliverySaveCommand command){
        deliveryService.save(command);
        return Result.success();
    }

    @GetMapping("/deleteDelivery")
    public Result deleteDelivery(@RequestParam String id) {
        deliveryService.delete(id);
        return Result.success();
    }

    @GetMapping("/selectById")
    public Result selectById(@RequestParam String id) {
        DeliveryQueryVO deliveryQueryVO = deliveryService.selectDelivery(id);
        return Result.success(deliveryQueryVO);
    }

    @PostMapping("/queryDeliveries")
    public Result queryTasks(@RequestBody DeliveryQueryCommand command){
        List<DeliveryQueryVO> deliveryQueryVOS = deliveryService.queryDeliveries(command);
        return Result.success(deliveryQueryVOS);
    }
}
