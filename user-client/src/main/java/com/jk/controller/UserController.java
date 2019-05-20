package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.pojo.RegType;
import com.jk.pojo.UserBean;
import com.jk.rmi.UserClient;
import com.jk.utils.Morse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserClient userClient;

    //登录完以后页面,点击注销按钮,注销
  /*  @RequestMapping("loginOut")
   public String loginOut(HttpServletRequest request) {
        return userClient.loginOut(request);
   }*/

    //判断手机号是否注册
    @RequestMapping("findUserByPhone")
    @ResponseBody
    public HashMap<String, Object> findUserByPhone(String phoneNumber) {
        return userClient.findUserByPhone(phoneNumber);
    }

    //短信验证码
    @RequestMapping("phoneTest")
    @ResponseBody
    public HashMap<String, Object> phoneTest(String phoneNumber) {
        return userClient.phoneTest(phoneNumber);
    }

    //用户注册类型
    @RequestMapping("findRegType")
    @ResponseBody
    public List<RegType> findRegType() {
        return userClient.findRegType();
    }

    //发货方 物流 注册
    @RequestMapping("reg")
    @ResponseBody
    public HashMap<String, Object> saveUser(UserBean userBean,String phonecode) {
        System.out.println(userBean.getTypes());
        return userClient.saveUser(userBean,phonecode);
    }

    // 前台登录+记住密码     usertype 1发货方,2物流公司
    @RequestMapping("login")
    @ResponseBody
    public HashMap<String,Object> login(UserBean userBean, HttpServletResponse response, HttpServletRequest request){
        UserBean user1 = userClient.login(userBean);
        HashMap<String, Object> hashMap= new HashMap<>();
        if (user1 != null) {
            //如果密码正确判断是否选择了记住密码
            if (userBean.getRemPwd() != null) {
                //如果选择了记住密码  存入cookie中
                Morse morse = new Morse();
                Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, user1.getPhoneNumber() + ConstantConf.splitC + morse.encryption(userBean.getPassword()));//TODO
                cookie.setMaxAge(604800);
                response.addCookie(cookie);
            } else {
                //如果没有勾选记住密码,只记住账号
                Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, userBean.getPhoneNumber());
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }
        } else {
            Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, userBean.getPhoneNumber());
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            hashMap.put("code", 1);
            hashMap.put("msg", "密码或者账号输入错误");
            return hashMap;
        }
        HttpSession session = request.getSession();
        session.setAttribute(session.getId(),user1);
        hashMap.put("type", user1.getUsertype());
        //TODO redis
        hashMap.put("code", 0);
        hashMap.put("msg", "登录成功");
        return hashMap;
    }

    //后台登录+记住密码   usertype 1发货方,2物流公司
    @RequestMapping("comLogin")
    @ResponseBody
    public HashMap<String,Object> comLogin(UserBean userBean, HttpServletResponse response, HttpServletRequest request){
        HashMap<String, Object> hashMap= new HashMap<>();
        if(userBean.getUsertype()==1){
            hashMap.put("code",1);
            hashMap.put("msg","您目前没有权限登录");
            return hashMap;
        }
        UserBean user1 = userClient.login(userBean);
        if (user1 != null) {
            //如果密码正确判断是否选择了记住密码
            if (userBean.getRemPwd() != null) {
                //如果选择了记住密码  存入cookie中     加密
                Morse morse = new Morse();
                Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, user1.getPhoneNumber() + ConstantConf.splitC + morse.encryption(userBean.getPassword()));//TODO
                cookie.setMaxAge(604800);
                response.addCookie(cookie);
            } else {
                //如果没有勾选记住密码,只记住账号
                Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, userBean.getPhoneNumber());
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }
        } else {
            Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, userBean.getPhoneNumber());
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            hashMap.put("code", 1);
            hashMap.put("msg", "密码或者账号输入错误");
            return hashMap;
        }
        HttpSession session = request.getSession();
        session.setAttribute(session.getId(),user1);
        hashMap.put("type", user1.getUsertype());
        hashMap.put("code", 0);
        hashMap.put("msg", "登录成功");
        return hashMap;
    }
    /*手机登录*/
    @RequestMapping("phoneLogin")
    @ResponseBody
    public  HashMap<String,Object> phoneLogin(UserBean userBean, String phonecode){
        return userClient.phoneLogin(userBean,phonecode);
    }
}