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
    public HashMap<String, Object> lineSearch(Integer page, Integer limit, Wuliuxianlu wuliuxianlu,HttpServletRequest request) {
        HttpSession session = request.getSession();
        CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
        Integer companyId = companyModel.getCompanyId();
        Integer count =frontdeskMapper.count(companyId);
        List<Wuliuxianlu> wuliuxianlus = frontdeskMapper.list((page-1)*limit,limit,wuliuxianlu,companyId);
        String start ="";
        String startplace="";
        String end ="";
        String endplace="";
        for (Wuliuxianlu wuliuxianlus1 : wuliuxianlus) {
            start = wuliuxianlus1.getStartId();
            if (start!=null) {
                AreaData areaName = frontdeskMapper.searchArea(start);
                String area = areaName.getArea();
                String city = areaName.getCity();
                String province = areaName.getProvince();
                startplace = province + city + area;
                wuliuxianlus1.setStartplace(startplace);
            }
            end = wuliuxianlus1.getEndId();
            if (end!=null) {
                AreaData areaName = frontdeskMapper.searchArea2(end);
                String area = areaName.getArea();
                String city = areaName.getCity();
                String province = areaName.getProvince();
                endplace = province + city + area;
                wuliuxianlus1.setEndplace(endplace);
            }
        }
        HashMap<String,Object> map= new HashMap<>();
        map.put("count",count);
        map.put("data",wuliuxianlus);
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
    public Wuliuxianlu editLine(String id) {
        Wuliuxianlu wuliuxianlu= frontdeskMapper.editLine(id);
        return wuliuxianlu;
    }

    @Override
    public List listData() {
        List list =  frontdeskMapper.listData();
        return list;
    }

    @Override
    public void add(Wuliuxianlu wusliuxianlu) {
        frontdeskMapper.add(wusliuxianlu);
    }

    @Override
    public void deleteData(int id) {
        frontdeskMapper.deleteData(id);
    }

    @Override
    public List<Wuliuxianlu> findAll() {
        return frontdeskMapper.findAll();
    }

    @Override
    public Wuliuxianlu queryOne(Integer id) {
      Wuliuxianlu wuliuxianlu=  frontdeskMapper.queryOne(id);
      return wuliuxianlu;
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
    public String addLine(Wuliuxianlu wuliuxianlu, HttpServletRequest request) {
       HttpSession session = request.getSession();
        CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
        Integer companyId = companyModel.getCompanyId();
        wuliuxianlu.setCompanyId(companyId);
        frontdeskMapper.addLine(wuliuxianlu);
        frontdeskMapper.addLine2(wuliuxianlu);
        return null;
    }

}
