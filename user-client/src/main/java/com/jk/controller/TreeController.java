package com.jk.controller;

import com.jk.pojo.TreeBean;
import com.jk.rmi.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TreeController {

    @Autowired
    UserClient userClient;
    //查询树
    @RequestMapping("findTreeList")
    @ResponseBody
    public List<TreeBean> findTreeList() {
        return userClient.findTreeList();
    }
}
