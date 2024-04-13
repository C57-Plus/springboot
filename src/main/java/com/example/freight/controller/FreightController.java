package com.example.freight.controller;

import com.example.common.Result;
import com.example.freight.service.FreightService;
import com.example.freight.vo.FreightQueryCommand;
import com.example.freight.vo.FreightQueryVO;
import com.example.freight.vo.FreightSaveCommand;
import com.example.site.service.SiteService;
import com.example.site.vo.SiteQueryCommand;
import com.example.site.vo.SiteQueryVO;
import com.example.site.vo.SiteSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freight")
public class FreightController {
    @Autowired
    private FreightService freightService;

    @PostMapping("/save")
    public Result save(@RequestBody FreightSaveCommand command){
        freightService.save(command);
        return Result.success();
    }

    @PostMapping("/selectFreight")
    public Result selectFreight(@RequestBody FreightQueryCommand command){
        FreightQueryVO freightQueryVO = freightService.selectFreight(command);
        return Result.success(freightQueryVO);
    }

    @PostMapping("/queryFreights")
    public Result queryFreights(@RequestBody FreightQueryCommand command){
        List<FreightQueryVO> freightQueryVOS = freightService.queryFreights(command);
        return Result.success(freightQueryVOS);
    }

    @GetMapping("/deleteFreight")
    public Result deleteFreight(@RequestParam String id){
        return Result.success(freightService.deleteFreight(id));
    }
}
