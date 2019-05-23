package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.MyLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    /*后台登录*/
    @RequestMapping("comLoginList")
    public String comLogin(){
        return "comLogin";
    }
}
