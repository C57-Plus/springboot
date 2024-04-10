package com.example.role.service;

import com.example.role.vo.RoleQueryVO;
import com.example.role.vo.RoleSaveCommand;

import java.util.List;

public interface RoleService {
    /**
     * 新增角色
     *
     * @param roleSaveCommand
     */
    void addRole(RoleSaveCommand roleSaveCommand);

    /**
     * 查询
     *
     * @param roleSaveCommand
     * @return {@link RoleQueryVO}
     */
    RoleQueryVO selectRole(RoleSaveCommand roleSaveCommand);

    /**
     * 批量查询
     *
     * @param roleSaveCommand
     * @return {@link List}<{@link RoleQueryVO}>
     */
    List<RoleQueryVO> queryVOS(RoleSaveCommand roleSaveCommand);

    int deleteRole(String id);

    void saveRole(RoleSaveCommand roleSaveCommand);
}
