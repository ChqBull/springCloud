package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageJumpController {

    /*跳转财务报表*/
    @RequestMapping("goFinancialStatements")
    public String goFinancialStatements(HttpServletRequest request){
        return "FinancialStatements";
    }
    /*跳转余额提现*/
    @RequestMapping("goBalanceWithdraw")
    public String goBalanceWithdraw(){
        return "BalanceWithdraw";
    }

    @RequestMapping("goLogin")
    public String goLogin(){
        return "Login";
    }

}
