package com.example.freight.service.impl;

import com.example.freight.entity.Freight;
import com.example.freight.mapper.FreightMapper;
import com.example.freight.service.FreightService;
import com.example.freight.vo.FreightQueryCommand;
import com.example.freight.vo.FreightQueryVO;
import com.example.freight.vo.FreightSaveCommand;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FreightServiceImpl implements FreightService {
    @Autowired
    private FreightMapper freightMapper;

    @Override
    public void save(FreightSaveCommand saveCommand){
        Freight freight = new Freight();
        BeanUtils.copyProperties(saveCommand, freight);
        if (StringUtil.isEmpty(saveCommand.getId())){
            // 新增
            freight.setId(UUIDUtil.get32UUID());
            String UserId = TokenUtils.getUserID();
            freight.setCreator(UserId);
            freight.setModifier(UserId);
            freightMapper.insert(freight);
        }else {
            // 修改
            freight.setModifier(TokenUtils.getUserID());
            freightMapper.updateFreight(freight);
        }
    }

    public int deleteFreight(String id){
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("id", id);
        cond.put("modifier", TokenUtils.getUserID());
        return freightMapper.deleteFreight(cond);
    }

    public List<FreightQueryVO> queryFreights(FreightQueryCommand command){
        Map<String, Object> map = new HashMap<>(3);
        map.put("name", command.getName());
        map.put("status", command.getStatus());
        map.put("type", command.getType());
        return freightMapper.queryFreights(map);
    }

    public FreightQueryVO selectFreight(FreightQueryCommand command){
        Map<String, Object> map = new HashMap<>(1);
        map.put("id", command.getId());
        return freightMapper.selectFreight(map);
    }

}
