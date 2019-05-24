package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.AnService;
import com.jk.util.AliyunOSSUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

@Controller
public class AbController {

    @Resource
    AnService anService;

    @RequestMapping("getzhuanxian")
    public String getzhuanxian(Integer id, Model model){
        zhuanxian patent=anService.getzhuanxian(id);
        if(patent!=null){
            Integer count=anService.findxianlucount(patent.getCompanyId());
            patent.setCount(count);
            model.addAttribute("c",patent);
            return  "zhuanxian";
        }
        return null;
    }

    @RequestMapping("getyesjilu")
    @ResponseBody
    public HashMap<String,Object> getyesjilu(){
        List<OrderBean>list=anService.getyesjilu();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",list);
        map.put("code","0");
        map.put("msg","");
        return  map;
    }

}
