package com.example.site.service.impl;

import com.example.site.entity.Site;
import com.example.site.mapper.SiteMapper;
import com.example.site.service.SiteService;
import com.example.site.vo.SiteQueryCommand;
import com.example.site.vo.SiteQueryVO;
import com.example.site.vo.SiteSaveCommand;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import com.github.pagehelper.dialect.helper.HsqldbDialect;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteMapper siteMapper;

    public void saveSite(SiteSaveCommand command){
        Site site = new Site();
        BeanUtils.copyProperties(command, site);
        if (StringUtil.isEmpty(command.getId())){
            // 新增
            site.setId(UUIDUtil.get32UUID());
            String UserId = TokenUtils.getUserID();
            site.setCreator(UserId);
            site.setModifier(UserId);
            siteMapper.insert(site);
        }else {
            // 修改
            site.setModifier(TokenUtils.getUserID());
            siteMapper.updateSite(site);
        }
    }

    public int deleteSite(String id){
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("id", id);
        cond.put("modifier", TokenUtils.getUserID());
        return siteMapper.deleteSite(cond);
    }

    public List<SiteQueryVO> querySites(SiteQueryCommand command){
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", command.getName());
        return siteMapper.querySites(map);
    }

    public SiteQueryVO selectSite(SiteQueryCommand command){
        Map<String, Object> map = new HashMap<>(1);
        map.put("id", command.getId());
        return siteMapper.selectSite(map);
    }
}
