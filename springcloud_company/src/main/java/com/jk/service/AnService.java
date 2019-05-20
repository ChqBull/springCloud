package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface AnService {

    void addgongsi(CompanyModel gongsi);

    List<Provinces> fingprovinces();

    List<Cities> findCity(Integer provinceid);

    List<Areas> findArea(Integer cityid);
}
