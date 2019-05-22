package com.jk.controller;


import com.jk.bean.*;
import com.jk.service.FrontdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class frontdesk {
    @Autowired
    private FrontdeskService frontdeskService;

    @RequestMapping("dd")
    public String dd(){
        return "ant";
    }

    @RequestMapping("findProvinc")
    @ResponseBody
    public List<Provinces> findProvinces(){
        return frontdeskService.findProvinces();
    }

    @RequestMapping("findCit")
    @ResponseBody
    public List<Cities> findCity(int provinceid){
        return frontdeskService.findCity(provinceid);
    }

    @RequestMapping("findAre")
    @ResponseBody
    public List<Areas> findArea(int cityid){
        return frontdeskService.findArea(cityid);
    }

    @RequestMapping("listData")
    @ResponseBody
    public List listData (){
        List list = frontdeskService.listData();
        return  list;
    }

    @RequestMapping("serviceArea")
    @ResponseBody
    public  List<AreaData> serviceArea(){
        List<AreaData> list =frontdeskService.serviceArea();
        return list;
    }
    @RequestMapping("companyList")
    @ResponseBody
    public List<OrderBean> companyList(){
        List<OrderBean> list =frontdeskService.companyList();
        return list;
    }

}
