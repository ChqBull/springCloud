package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.FrontdeskMapper;
import com.jk.service.FrontdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontdeskServiceImpl implements FrontdeskService {
    @Autowired
    FrontdeskMapper frontdeskMapper;

    @Override
    public List<AreaData> serviceArea(Integer statrsquId) {
       return frontdeskMapper.serviceArea(statrsquId);
    }

    @Override
    public List<Wuliuxianlu> companyList(Integer statrsquId,Integer endquId) {
        List<Wuliuxianlu> list= frontdeskMapper.companyList(statrsquId,endquId);
        String place = "";
        String place2 = "";
        for (Wuliuxianlu orderBean : list) {
            String startAreaId = orderBean.getStartId();
            if (startAreaId!=null) {
                AreaData areaName = frontdeskMapper.searchArea4(startAreaId);
                String area = areaName.getArea();
                String city = areaName.getCity();
                place = city + area;
                orderBean.setShiId(city);
                orderBean.setStartplace(place);
            }

            String endAreaId = orderBean.getEndId();
            if (endAreaId!=null) {
                AreaData areaName2 = frontdeskMapper.searchArea3(endAreaId);
                String area2 = areaName2.getArea();
                String city2 = areaName2.getCity();
                place2 = city2 + area2;
                orderBean.setShiId2(city2);
                orderBean.setEndplace(place2);
            }
        }
        return list;

    }
}
