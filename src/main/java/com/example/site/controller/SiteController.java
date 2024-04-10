package com.example.site.controller;

import com.example.common.Result;
import com.example.role.vo.RoleQueryVO;
import com.example.role.vo.RoleSaveCommand;
import com.example.site.service.SiteService;
import com.example.site.vo.SiteQueryCommand;
import com.example.site.vo.SiteQueryVO;
import com.example.site.vo.SiteSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @PostMapping("/save")
    public Result save(@RequestBody SiteSaveCommand command){
        siteService.saveSite(command);
        return Result.success();
    }

    @PostMapping("/querySites")
    public Result querySites(@RequestBody SiteQueryCommand command){
        List<SiteQueryVO> siteQueryVOS = siteService.querySites(command);
        return Result.success(siteQueryVOS);
    }

    @GetMapping("/deleteSite")
    public Result deleteSite(@RequestParam String id){
        return Result.success(siteService.deleteSite(id));
    }

}
