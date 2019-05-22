package com.jk.rmi;

import com.jk.bean.UserBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient("userserver")//调用生产者注入到注册中心的值
public interface UserClient {

   //判断手机号是否注册
   @RequestMapping("findUserByPhone")
   public HashMap<String, Object>  findUserByPhone(@RequestParam("phoneNumber") String phoneNumber);

   //短信验证码
   @RequestMapping("phoneTest")
   public HashMap<String, Object> phoneTest(@RequestParam("phoneNumber") String phoneNumber);

   //发货方 物流 注册
   @RequestMapping("reg")
   HashMap<String, Object> saveUser(@RequestBody UserBean userBean, @RequestParam("phonecode") String phonecode);

   // 前台登录,后台登录+记住密码     usertype 1发货方,2物流公司
   @RequestMapping("login")
   UserBean login(@RequestBody UserBean userBean);

   /*手机登录*/
   @RequestMapping("phoneLogin")
   HashMap<String, Object> phoneLogin(@RequestBody UserBean userBean, @RequestParam("phonecode") String phonecode);

}
