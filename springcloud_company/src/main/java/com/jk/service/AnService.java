package com.jk.service;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnService {

    void addgongsi(@Param("gongso")CompanyModel gongsi);

    List<Provinces> fingprovinces();

    List<Cities> findCity(Integer provinceid);

    List<Areas> findArea(Integer cityid);
}
