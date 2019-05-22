package com.jk.service;

import com.jk.bean.Areas;
import com.jk.bean.Cities;
import com.jk.bean.OrderBean;
import com.jk.bean.Provinces;

import javax.servlet.http.HttpServletRequest;
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


    OrderBean queryOne(Integer id);

    String address(Integer area1, Integer area2);

    String addLine(OrderBean orderBean, HttpServletRequest request);

}
