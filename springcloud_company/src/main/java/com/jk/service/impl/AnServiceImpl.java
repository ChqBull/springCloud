package com.jk.service.impl;

import com.jk.bean.Areas;
import com.jk.bean.Cities;
import com.jk.bean.CompanyModel;
import com.jk.bean.Provinces;
import com.jk.mapper.AnMapper;
import com.jk.service.AnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnServiceImpl implements  AnService{

    @Resource
    AnMapper anMapper;



    @Override
    public void addgongsi(CompanyModel gongsi) {

        anMapper.addgongsi(gongsi);
    }

    @Override
    public List<Provinces> fingprovinces() {
        return anMapper.fingprovinces();
    }

    @Override
    public List<Cities> findCity(Integer provinceid) {
        return anMapper.findCity(provinceid);
    }

    @Override
    public List<Areas> findArea(Integer cityid) {
        return anMapper.findArea(cityid);
    }

    @Override
    public void addtupian(CompanyModel gongsi) {
        anMapper.addtupian(gongsi);
    }

    @Override
    public CompanyModel findgongsi(Integer companyId) {
        return anMapper.findgongsi(companyId);
    }
}
