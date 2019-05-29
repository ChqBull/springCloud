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

    /*蚂蚁前台登录后去的页面(*/
    @MyLog(value = "用户登录记录")
    @RequestMapping("main")
    public String main(){
        return "wuLiuMain";
    }

    //登录完以后页面,点击退出按钮,退出
    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();//获取session
        session.removeAttribute(session.getId());//移出账号
        return "login";//跳转到登录页面
    }

    /*蚂蚁前台登录*/
    @RequestMapping("loginList")
    public String loginList(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();//把存进cookies的值取出来
        if(cookies != null){
            for (Cookie cookie : cookies) {//遍历取值
                if (cookie.getName().equals(ConstantConf.cookieNamePaw)) {//如果cookies的值=前台传过来的值
                    String value = cookie.getValue();
                    if (value != null) {
                        String[] split = value.split(ConstantConf.splitC);
                        model.addAttribute("phoneNumber", split[0]);
                        model.addAttribute("password", split[1]);
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

    /*前台登录后修改密码*/
    @RequestMapping("xgma")
    public String updatePassword(){
        return "xgma";
    }

    /*蚂蚁树*/
    @RequestMapping("treeMain")
    public String treeMain(){
        return "treeMain";
    }

    //蚂蚁树登录完以后页面,点击退出按钮,退出
    @RequestMapping("loginOutTree")
    public String loginOutTree(HttpServletRequest request) {
        return "comLogin";//跳转到登录页面
    }

}
