package com.example.site.service;

import com.example.site.vo.SiteQueryCommand;
import com.example.site.vo.SiteQueryVO;
import com.example.site.vo.SiteSaveCommand;
import com.github.pagehelper.util.StringUtil;

import java.util.List;

public interface SiteService {
    /**
     * 保存站点
     *
     * @param command
     */
    void saveSite(SiteSaveCommand command);

    /**
     * 删除站点（逻辑）
     *
     * @param id
     * @return int
     */
    int deleteSite(String id);

    /**
     * 查询站点（批量）
     *
     * @param command
     * @return {@link List}<{@link SiteQueryVO}>
     */
    List<SiteQueryVO> querySites(SiteQueryCommand command);

    /**
     * 查询站点
     *
     * @param command
     * @return {@link SiteQueryVO}
     */
    SiteQueryVO selectSite(SiteQueryCommand command);

}
