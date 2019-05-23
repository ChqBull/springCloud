package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.bean.CompanyModel;
import com.jk.bean.UserBean;
import com.jk.rmi.UserClient;
import com.jk.service.UserService;
import com.jk.util.Morse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    UserClient userClient;

    @Autowired
    UserService userService;

    //后台登录+记住密码   usertype 1发货方,2物流公司
    @RequestMapping("comLogin")
    @ResponseBody
    public HashMap<String,Object> comLogin(UserBean userBean, HttpServletResponse response, HttpServletRequest request){
        HashMap<String, Object> hashMap= new HashMap<>();
        /*根据手机号判断用户类型   1发货方 2物流*/
        if(userBean.getUsertype()==1){
            hashMap.put("code",1);
            hashMap.put("msg","您目前没有权限登录");
            return hashMap;
        }
        CompanyModel companyModel = userClient.comlogin(userBean);
        if (companyModel != null) {
            HttpSession session = request.getSession();
            session.setAttribute(session.getId(),companyModel);
            hashMap.put("code", 0);
            hashMap.put("msg", "登录成功");
            return hashMap;
        } else {
            hashMap.put("code", 1);
            hashMap.put("msg", "密码或者账号输入错误");
            return hashMap;
        }
    }

}