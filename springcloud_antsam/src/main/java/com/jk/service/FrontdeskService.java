package com.jk.service;

import com.jk.bean.*;

import java.util.HashMap;
import java.util.List;

public interface FrontdeskService {
    HashMap<String,Object> lineSearch(Integer page, Integer limit, OrderBean orderBean);

    List<Provinces> findProvinces();

    List<Cities> findCity(int provinceid);

    List<Areas> findArea(int cityid);

    OrderBean editLine(Integer id);

    List listData();

    void add(OrderBean orderBean);

    void deleteData(int id);

    List<OrderBean> findAll();


}
