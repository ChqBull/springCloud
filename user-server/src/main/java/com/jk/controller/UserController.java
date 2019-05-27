package com.jk.controller;
import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;

   //判断手机号是否注册
    @RequestMapping("findUserByPhone")
    @ResponseBody
    public HashMap<String, Object>  findUserByPhone(String phoneNumber) {
        return userService. findUserByPhone(phoneNumber);
    }

   //短信验证码
    @RequestMapping("phoneTest")
    @ResponseBody
    public HashMap<String, Object>  phoneTest(String phoneNumber) {
        return userService. phoneTest(phoneNumber);
    }


    //发货方 物流 注册
    @RequestMapping("reg")
    @ResponseBody
    public HashMap<String,Object> saveUser(@RequestBody UserBean userBean,@RequestParam("phonecode") String phonecode){
        return userService.saveUser(userBean,phonecode);
    }

    // 前台登录+记住密码     usertype 1发货方,2物流公司
    @RequestMapping("login")
    @ResponseBody
    public UserBean login(@RequestBody UserBean userBean){
        return userService.login(userBean);
    }


    //后台登录+记住密码   usertype 1发货方,2物流公司
    @RequestMapping("comLogin")
    @ResponseBody
    public UserBean comLogin(@RequestBody UserBean userBean){
        return userService.login(userBean);
    }

    /*手机登录*/
    @RequestMapping("phoneLogin")
    @ResponseBody
    public  HashMap<String,Object> phoneLogin(@RequestBody UserBean userBean, String phonecode){
        return userService.phoneLogin(userBean,phonecode);
    }
}
