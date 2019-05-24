package com.jk.controller;

import com.jk.bean.CashModel;
import com.jk.service.CashService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class CashController {

  @Resource
  CashService cashService;

  @RequestMapping("getcash")
  public String getcash(){

    return  "cashhtml";
  }
  @RequestMapping("queryOrder")
  @ResponseBody
  public HashMap<String ,Object> queryOrder(Integer page, Integer limit){
    //List<CashModel> list1 = cashService.getOrder();

    List<CashModel> list2 = cashService.getOrderByCondition(page,limit);

    HashMap<String,Object> tableData =new HashMap<String,Object>();
    long money = cashService.getMoney();
    tableData.put("code", 0);
    tableData.put("msg", "");
    tableData.put("count", money);
    tableData.put("data", list2);

    return tableData;

  }
   @RequestMapping("editLine")
   @ResponseBody
  public void editLine(Integer amount,Integer id,Integer cid){
       cashService.editLine(amount,id,cid);
   }
}
