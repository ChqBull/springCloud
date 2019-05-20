package com.jk.controller;

import com.jk.bean.Areas;
import com.jk.bean.Cities;
import com.jk.bean.Provinces;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("city")
public class LiandongBiao {
      @Autowired
      private OrderService service;
      @RequestMapping("findProvinces")
      @ResponseBody
     public List<Provinces> queryProvinces(){
         return service.queryProvinces();
     }
    @RequestMapping("findCity")
    @ResponseBody
    public List<Cities> findCity(Integer provinceid){
        return service.findCity(provinceid);
    }

    @RequestMapping("findArea")
    @ResponseBody
    public List<Areas> findArea(Integer cityid){
        return service.findArea(cityid);
    }

}
