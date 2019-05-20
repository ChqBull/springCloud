package com.jk.service;

import com.jk.bean.*;
import com.jk.mapper.AnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnServiceImpl  implements  AnService{

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
}
