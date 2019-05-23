package com.jk.controller;

import com.jk.ConstantConf;
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


    //发货方 物流 注册
    @RequestMapping("reg")
    @ResponseBody
    public HashMap<String, Object> saveUser(UserBean userBean,String phonecode) {
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
                Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, user1.getPhoneNumber() + ConstantConf.splitC + user1.getPassword());
                cookie.setMaxAge(604800);//过期时间为一周
                response.addCookie(cookie);

            }else {
                //如果没有勾选记住密码,清除cookie
                Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, "");
                cookie.setMaxAge(0);//
                response.addCookie(cookie);
               /* Cookie cookie = new Cookie(ConstantConf.cookieNamePaw, userBean.getPhoneNumber());
                cookie.setMaxAge(3600);
                response.addCookie(cookie);*/
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

    /*手机登录*/
    @RequestMapping("phoneLogin")
    @ResponseBody
    public  HashMap<String,Object> phoneLogin(UserBean userBean, String phonecode){
        return userClient.phoneLogin(userBean,phonecode);
    }

    /*登录完前台获取登录名*/
    @RequestMapping("sessionPhoneNumber")
    @ResponseBody
    public HashMap<String,Object> sessionPhoneNumber(HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        HttpSession session = request.getSession();
        UserBean  user = (UserBean)session.getAttribute(session.getId());
        String phoneNumber = user.getPhoneNumber();//获取手机号
        Integer usertype = user.getUsertype();//用户类型  1发货方  2物流公司
        String a="";
        if(usertype==1){
            a="发货方";
        }else{
            a="物流公司";
        }
        String createTime = user.getCreateTime();//注册时间
        user.setPhoneMember((int) (Math.random() * 89999 + 10000));//自动加入随机数
        Integer phoneMember = user.getPhoneMember();//会员ID
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(new Date());
        user.setLastTime(format);//登录时间
        String lastTime = user.getLastTime();//登录时间
        hashMap.put("username",phoneNumber);
        hashMap.put("createTime",createTime);
        hashMap.put("group",a);
        hashMap.put("phoneMember",phoneMember);
        hashMap.put("lastTime",lastTime);
        return hashMap;
    }

}