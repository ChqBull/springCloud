package com.jk.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.jk.util.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller

public class ApiController {
    @RequestMapping("toNewsApi")
   public String toNewsApi(){

        return "toNewsApi";
    }

    @RequestMapping("XinWenXiangQing")
    public String XinWenXiangQing(String content, Model model){
        model.addAttribute("c",content);
        return "XinWenXiangQing";
    }

    @RequestMapping("newsApi")
    @ResponseBody
public HashMap<String,Object> newsApi(){
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Object> tableData = new HashMap<>();
        hashMap.put("channel","头条");
        hashMap.put("num",10);
        hashMap.put("start",0);
        hashMap.put("appkey","014e948d3fbccf44");
        String str = HttpClient.sendGet("https://api.jisuapi.com/news/get", hashMap);
        JSONObject json = JSONObject.fromObject(str);
        JSONObject resultarr = (JSONObject) json.opt("result");
        JSONArray list = resultarr.optJSONArray("list");
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", list.size());
        tableData.put("data", list);

        return tableData;
    }



}
