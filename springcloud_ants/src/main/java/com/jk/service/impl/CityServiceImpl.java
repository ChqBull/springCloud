package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.CityMapper;
import com.jk.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<Provinces> findProvinces() {
        return cityMapper.findProvinces();
    }

    @Override
    public List<Cities> findCity(String provinceid) {
        return cityMapper.findCity(provinceid);
    }

    @Override
    public List<Areas> findArea(String cityid) {
        return cityMapper.findArea(cityid);
    }

    @Override
    public List<Cities> cityGroup(String str) {
        return cityMapper.cityGroup(str);
    }

    @Override
    public List<HualingTrack> findHualingTrack(String str) {
        return cityMapper.findHualingTrack(str);
    }

    @Override
    public List<Cities> findCityById() {
        return cityMapper.findCityById();
    }

    @Override
    public List<HualingTrack> findLineByCityid(HualingTrack hualingTrack) {
        return cityMapper.findLineByCityid(hualingTrack);
    }

    @Override
    public List<Order> findOrder() {
        return cityMapper.findOrder();
    }

    @Override
    public List<Image> findImg() {
        return cityMapper.findImg();
    }
}
