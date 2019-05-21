package com.jk.service;

import com.jk.bean.*;

import java.util.HashMap;
import java.util.List;

public interface FrontdeskService {

    List<Provinces> findProvinces();

    List<Cities> findCity(int provinceid);

    List<Areas> findArea(int cityid);

    List listData();

    void add(OrderBean orderBean);

    List<AreaData> serviceArea();

    List<OrderBean> companyList();
}
