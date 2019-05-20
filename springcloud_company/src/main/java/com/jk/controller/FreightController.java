package com.jk.controller;

import com.jk.bean.Freight;
import com.jk.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("freight")
public class FreightController {

    @Autowired
    private FreightService freightService;

    @RequestMapping("findFreightAll")
    @ResponseBody
    public Map<String,Object> findFreightAll(int page, int limit, Freight freight){
        return freightService.findFreightAll(page,limit,freight);
    }
}
