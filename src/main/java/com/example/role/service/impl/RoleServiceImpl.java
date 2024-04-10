package com.example.role.service.impl;

import com.example.exception.CustomException;
import com.example.role.entity.Role;
import com.example.role.mapper.RoleMapper;
import com.example.role.service.RoleService;
import com.example.role.vo.RoleQueryVO;
import com.example.role.vo.RoleSaveCommand;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addRole(RoleSaveCommand roleSaveCommand){
        Role role = new Role();
        BeanUtils.copyProperties(roleSaveCommand, role);

        RoleSaveCommand command = new RoleSaveCommand();
        command.setCode(roleSaveCommand.getCode());
        RoleQueryVO roleQueryVO = this.selectRole(command);
        if (roleQueryVO!=null){
            throw new CustomException("500","角色标识不可重复");
        }

        role.setId(UUIDUtil.get32UUID());
        String userID = TokenUtils.getUserID();
        role.setCreator(userID);
        role.setModifier(userID);
        roleMapper.insert(role);
    }

    public void saveRole(RoleSaveCommand roleSaveCommand){
        Role role = new Role();
        BeanUtils.copyProperties(roleSaveCommand, role);

        role.setModifier(TokenUtils.getUserID());
        roleMapper.updateRole(role);
    }

    public RoleQueryVO selectRole(RoleSaveCommand roleSaveCommand){
        Map<String, Object> cond = new HashMap<>(3);
        cond.put("id", roleSaveCommand.getId());
        cond.put("name", roleSaveCommand.getName());
        cond.put("code", roleSaveCommand.getCode());

        return roleMapper.selectRole(cond);
    }

    public List<RoleQueryVO> queryVOS(RoleSaveCommand roleSaveCommand){
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("name", roleSaveCommand.getName());
        cond.put("code", roleSaveCommand.getCode());

        return roleMapper.queryRoles(cond);
    }

    public int deleteRole(String id){
        return roleMapper.deleteRole(id);
    }
}
