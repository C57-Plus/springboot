package com.example.site.mapper;

import com.example.role.entity.Role;
import com.example.role.vo.RoleQueryVO;
import com.example.site.entity.Site;
import com.example.site.vo.SiteQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SiteMapper {
    int insert(Site site);

    int updateSite(Site site);

    int deleteSite(Map<String, Object> cond);

    SiteQueryVO selectSite(Map<String, Object> cond);

    List<SiteQueryVO> querySites(Map<String, Object> cond);
}
