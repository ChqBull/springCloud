package com.jk.controller;

import com.jk.pojo.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /*蚂蚁前台登录去的页面*/
    @RequestMapping("main")
    public String mian(){
        return "wuLiuMain";
    }


    /*蚂蚁前台登录*/
    @RequestMapping("loginList")
    public String comLoginList(){
        return "login";
    }

    /*后台登录*/
    @RequestMapping("comLoginList")
    public String comLogin(Model model, UserBean userBean){
        model.addAttribute("userBean",userBean);
        return "comLogin";
    }

    /*点击注册去的两个注册页面*/
    @RequestMapping("regs")
    public String regs(){
        return "regs";
    }

    /*点击注册去的两个注册页面,发货方,物流公司*/
    @RequestMapping("regsFaHuo")
    public String regsFaHuo(Model model,Integer usertype){
        model.addAttribute("usertype",usertype);
        return "faHuoAndwuLiu";
    }
    /*手机登录*/
    @RequestMapping("toPhoneLogin")
    public String toPhoneLogin(){
        return "phoneLogin";
    }
}
