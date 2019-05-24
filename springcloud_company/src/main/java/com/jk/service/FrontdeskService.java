package com.jk.service;

import com.jk.bean.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface FrontdeskService {
    HashMap<String,Object> lineSearch(Integer page, Integer limit, Wuliuxianlu wuliuxianlu, HttpServletRequest request);

    List<Provinces> findProvinces();

    List<Cities> findCity(int provinceid);

    List<Areas> findArea(int cityid);

    Wuliuxianlu editLine(String id);

    List listData();

    void add(Wuliuxianlu wuliuxianlu);

    void deleteData(int id);

    List<Wuliuxianlu> findAll();


    Wuliuxianlu queryOne(Integer id);

    String address(Integer area1, Integer area2);

    String addLine(Wuliuxianlu orderBean, HttpServletRequest request);

}
