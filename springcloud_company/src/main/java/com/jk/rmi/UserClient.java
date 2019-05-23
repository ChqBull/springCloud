package com.jk.rmi;

import com.jk.bean.CompanyModel;
import com.jk.bean.UserBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient("USERSERVER")//调用生产者注入到注册中心的值
public interface UserClient {

   // 前台登录,后台登录+记住密码     usertype 1发货方,2物流公司
   @RequestMapping("login")
   UserBean login(@RequestBody UserBean userBean);

   @RequestMapping("comLogin")
   CompanyModel comlogin(@RequestBody UserBean userBean);
}
