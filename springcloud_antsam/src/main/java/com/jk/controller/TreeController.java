package com.jk.controller;

import com.jk.bean.TreeBean;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TreeController {
    @Autowired
    TreeService treeService;

    @RequestMapping("index")
    public String goIndex(){

        return "treeMain";
    }

    //查询树
    @RequestMapping("findTreeList")
    @ResponseBody
    public List<TreeBean> findTreeList() {
        List<TreeBean> findTreeList = treeService.findTreeList();
        return findTreeList;
    }
}
