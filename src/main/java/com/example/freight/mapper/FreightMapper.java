package com.example.freight.mapper;

import com.example.freight.entity.Freight;
import com.example.freight.vo.FreightQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FreightMapper {
    void insert(Freight freight);

    int updateFreight(Freight freight);

    int deleteFreight(Map<String, Object> cond);

    FreightQueryVO selectFreight(Map<String, Object> cond);

    List<FreightQueryVO> queryFreights(Map<String, Object> cond);
}
