package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.*;
import com.jk.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("findProvinces")
    public List<Provinces> findProvinces(){
        return cityService.findProvinces();
    }

    @RequestMapping("findCity")
    public List<Cities> findCity(String provinceid){
        return cityService.findCity(provinceid);
    }

    @RequestMapping("findArea")
    public List<Areas> findArea(String cityid){
        return cityService.findArea(cityid);
    }

    @RequestMapping("cityGroup")
    public List<Cities> cityGroup(String str){
        ValueOperations ops = redisTemplate.opsForValue();
        if (ops.get(str)!=null){
//            Object obj= ops.get(str);
//            String s= JSON.toJSON(obj).toString();
            List<Cities> list=JSON.parseArray((String) ops.get(str),Cities.class);
            return list;
        }else {
            List<Cities> list = cityService.cityGroup(str);
            ops.set(str,JSON.toJSONString(list));
            return list;
        }

    }


    @RequestMapping("findHualingTrack")
    public List<HualingTrack> findHualingTrack(String str){
        return cityService.findHualingTrack(str);
    }

    @RequestMapping("findCityById")
    public List<Cities> findCityById(){
        return cityService.findCityById();
    }

    @RequestMapping("findLineByCityid")
    public List<HualingTrack> findLineByCityid(HualingTrack hualingTrack){
        return cityService.findLineByCityid(hualingTrack);
    }

    @RequestMapping("findOrder")
    public List<Order> findOrder(){
        return cityService.findOrder();
    }

    @RequestMapping("findImg")
    public List<Image> findImg(){
        return cityService.findImg();
    }
}
