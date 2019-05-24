package com.jk.controller;


import com.jk.bean.*;
import com.jk.service.FrontdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class frontdesk {
    @Autowired
    private FrontdeskService frontdeskService;

    @RequestMapping("cc")
    public String cc(Integer startquid, Integer endquid, Model model){
        Areas areas = new Areas();
        areas.setStartquid(startquid);
        areas.setEndquid(endquid);
        model.addAttribute("a",areas);
        return "antfront";
    }

    @RequestMapping("serviceArea")
    @ResponseBody
    public  List<AreaData> serviceArea(Integer statrsquId){
        List<AreaData> list =frontdeskService.serviceArea(statrsquId);
        return list;
    }
    @RequestMapping("companyList")
    @ResponseBody
    public List<Wuliuxianlu> companyList(Integer statrsquId,Integer endquId){
        List<Wuliuxianlu> list =frontdeskService.companyList(statrsquId,endquId);
        return list;
    }

}
