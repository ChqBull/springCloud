package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.util.Morse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    /*蚂蚁前台登录后去的页面(假的)*/
    @RequestMapping("main")
    public String main(){

        return "wuLiuMain";
    }


  /* 蚂蚁前台登录*//*
    @RequestMapping("loginList")
    public String comLoginList(){
        return "login";
    }*/

    /*蚂蚁前台登录*/
    @RequestMapping("loginList")
    public String comLogin(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        Morse morse = new Morse();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(ConstantConf.cookieNamePaw)) {
                    String value = cookie.getValue();
                    if (value != null) {
                        String[] split = value.split(ConstantConf.splitC);
                        if(split.length>1){
                            model.addAttribute("phoneNumber", split[0]);
                            model.addAttribute("password", morse.decode(split[1]));
                        }else{
                            model.addAttribute("phoneNumber", split[0]);
                        }
                    }
                }
            }
        }
        return "login";
    }

    /*后台登录*/
    @RequestMapping("comLoginList")
    public String comLogin(){
        return "comLogin";
    }

    /*点击注册两个按钮注册页面*/
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
