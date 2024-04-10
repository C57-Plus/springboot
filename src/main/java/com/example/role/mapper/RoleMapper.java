package com.example.role.mapper;


import com.example.role.entity.Role;
import com.example.role.vo.RoleQueryVO;
import com.example.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface RoleMapper {
    void insert(Role role);

    int updateRole(Role role);

    int deleteRole(String id);

    RoleQueryVO selectRole(Map<String, Object> cond);

    List<RoleQueryVO> queryRoles(Map<String, Object> cond);
}
