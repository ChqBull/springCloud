package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.FrontdeskMapper;
import com.jk.service.FrontdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FrontdeskServiceImpl implements FrontdeskService {
    @Autowired
    FrontdeskMapper frontdeskMapper;

    @Override
    public List<Provinces> findProvinces() {
        List<Provinces> list = frontdeskMapper.findProvinces();
        return list;
    }

    @Override
    public List<Cities> findCity(int provinceid) {
        System.out.println();
        return frontdeskMapper.findCity(provinceid);
    }

    @Override
    public List<Areas> findArea(int cityid) {
        System.out.println();
        return frontdeskMapper.findArea(cityid);
    }



    @Override
    public List listData() {
        List list =  frontdeskMapper.listData();
        return list;
    }

    @Override
    public void add(OrderBean orderBean) {
        frontdeskMapper.add(orderBean);
    }



    @Override
    public List<AreaData> serviceArea() {
       return frontdeskMapper.serviceArea();
    }

    @Override
    public List<OrderBean> companyList() {
        List<OrderBean> list= frontdeskMapper.companyList();
        String place = "";
        String place2 = "";
        for (OrderBean orderBean : list) {
            String cityId = orderBean.getStartplace();
            if (cityId!=null) {
                AreaData areaName = frontdeskMapper.searchArea4(cityId);
                String area = areaName.getArea();
                String city = areaName.getCity();
                place = city + area;
                orderBean.setShiId(city);
                orderBean.setStartplace(place);
            }
          AreaData areaName2 = frontdeskMapper.searchArea3();
            String area2 = areaName2.getArea();
            String city2 = areaName2.getCity();
            place2 = city2 + area2;
            orderBean.setShiId2(city2);
            orderBean.setEndplace(place2);
        }
        return list;

    }
}
