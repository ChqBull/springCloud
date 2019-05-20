package com.jk.service.impl;

import com.jk.bean.Freight;
import com.jk.mapper.FreightMapper;
import com.jk.service.FreightService;
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
    public Map<String, Object> findFreightAll(int page, int limit, Freight freight) {
        int count=freightMapper.count(freight);
        List<Freight> list=freightMapper.findFreightAll((page-1)*limit,limit,freight);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
}
