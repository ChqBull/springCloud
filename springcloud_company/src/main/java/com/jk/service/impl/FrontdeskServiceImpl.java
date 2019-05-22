package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.FrontdeskMapper;
import com.jk.service.FrontdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class FrontdeskServiceImpl implements FrontdeskService {
    @Autowired
    FrontdeskMapper frontdeskMapper;

    @Override
    public HashMap<String, Object> lineSearch(Integer page, Integer limit, OrderBean orderBea) {
        Integer count =frontdeskMapper.count();
        List<OrderBean> orderBeans = frontdeskMapper.list(page,limit,orderBea);
        Integer start =0;
        String startplace="";
        Integer end =0;
        String endplace="";
        for (OrderBean orderBean : orderBeans) {
            start = orderBean.getStatrsquId();
            if (start!=null) {
                AreaData areaName = frontdeskMapper.searchArea(start);
                String area = areaName.getArea();
                String city = areaName.getCity();
                String province = areaName.getProvince();
                startplace = province + city + area;
                orderBean.setStartplace(startplace);
            }
            end = orderBean.getEndquId();
            if (end!=null) {
                AreaData areaName = frontdeskMapper.searchArea2(end);
                String area = areaName.getArea();
                String city = areaName.getCity();
                String province = areaName.getProvince();
                endplace = province + city + area;
                orderBean.setEndplace(endplace);
            }
        }
        HashMap<String,Object> map= new HashMap<>();
        map.put("count",count);
        map.put("data",orderBeans);
        map.put("code",0);
        return map;
    }

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
    public OrderBean editLine(Integer id) {
        OrderBean orderBean= frontdeskMapper.editLine(id);
        return orderBean;
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
    public void deleteData(int id) {
        frontdeskMapper.deleteData(id);
    }

    @Override
    public List<OrderBean> findAll() {
        return frontdeskMapper.findAll();
    }

    @Override
    public OrderBean queryOne(Integer id) {
      OrderBean orderBean=  frontdeskMapper.queryOne(id);
      return orderBean;
    }

    @Override
    public String address(Integer area1, Integer area2) {
        String aa ="";
        String startplace="";
        String endplace="";
        if (area1!=null) {
            AreaData areaName = frontdeskMapper.searchArea5(area1);
            String area = areaName.getArea();
            String city = areaName.getCity();
            String province = areaName.getProvince();
            startplace = province + city + area;
        }
        if (area2!=null) {
            AreaData areaName = frontdeskMapper.searchArea5(area2);
            String area = areaName.getArea();
            String city = areaName.getCity();
            String province = areaName.getProvince();
            endplace = province + city + area;
        }
        aa = startplace+"到"+endplace;
        return aa;



    }

    @Override
    public String addLine(OrderBean orderBean, HttpServletRequest request) {
      /*  HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute(session.getId());
        Integer companyId = userBean.getCompanyId();*/
        orderBean.setCompanyId(2);
        frontdeskMapper.addLine(orderBean);
        return null;
    }

}
