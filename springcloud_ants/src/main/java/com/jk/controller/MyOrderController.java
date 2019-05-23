package com.jk.controller;

import com.jk.bean.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class MyOrderController {
        @Autowired
       OrderService service;

       @RequestMapping("MyOrderPage")
       public String MyOrderPage(){

            return "MyOrderPage";
        }



      @RequestMapping("queryMyOrder")
      @ResponseBody
     public HashMap<String,Object>queryMyOrder(Integer page, Integer limit, OrderBean order){
          HashMap<String, Object> hashMap = new HashMap<>();
         List<OrderBean> list = service.queryMyOrder(page,limit,order);
          hashMap.put("code", 0);
          hashMap.put("msg", "");
          hashMap.put("count", list.size());
          hashMap.put("data", list);
          return hashMap;
      }



}
