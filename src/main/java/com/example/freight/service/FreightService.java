package com.example.freight.service;

import com.example.freight.vo.FreightQueryCommand;
import com.example.freight.vo.FreightQueryVO;
import com.example.freight.vo.FreightSaveCommand;

import java.util.List;

public interface FreightService {
    void save(FreightSaveCommand saveCommand);

    int deleteFreight(String id);

    List<FreightQueryVO> queryFreights(FreightQueryCommand command);

    FreightQueryVO selectFreight(FreightQueryCommand command);
}
