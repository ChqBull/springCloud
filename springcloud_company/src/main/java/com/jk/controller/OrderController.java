package com.jk.controller;

import com.jk.bean.CompanyModel;
import com.jk.bean.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {
      @Autowired
      private OrderService service;
@RequestMapping("queryOrder")
@ResponseBody
      public HashMap<String ,Object> queryOrder(Integer page, Integer limit, OrderBean orderBean, Model model, HttpServletRequest request){
    HttpSession session = request.getSession();
          CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
          Integer companyId = companyModel.getCompanyId();
          orderBean.setCompanyId(companyId);
        List<OrderBean> list1 = service.getOrder(orderBean);

        List<OrderBean> list2 = service.getOrderByCondition(page,limit,orderBean);

          HashMap<String,Object> tableData =new HashMap<String,Object>();
        // Long money = service.getMoney();
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", list1.size());
        tableData.put("data", list2);
     /*   model.addAttribute("money",money);
        model.addAttribute("count",list2.size());*/
        return tableData;

    }
//运算在途的查询
    @RequestMapping("queryOrderzaidu")
    @ResponseBody
    public HashMap<String ,Object> queryOrderzaidu(Integer page, Integer limit, OrderBean orderBean, Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
        Integer companyId = companyModel.getCompanyId();
        orderBean.setCompanyId(companyId);

        List<OrderBean> list1 = service.getOrder(orderBean);

        List<OrderBean> list2 = service.getOrderByConditionzaidu(page,limit,orderBean);

        HashMap<String,Object> tableData =new HashMap<String,Object>();
      /*  Long money = service.getMoney();*/
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", list1.size());
        tableData.put("data", list2);
      /*  model.addAttribute("money",money);
        model.addAttribute("count",list2.size());*/
        return tableData;

    }
//运费结算的查询
@RequestMapping("queryOrderyunsuan")
@ResponseBody
public HashMap<String ,Object> queryOrderyunsuan(Integer page, Integer limit, OrderBean orderBean, Model model,HttpServletRequest request){

    HttpSession session = request.getSession();
    CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
    Integer companyId = companyModel.getCompanyId();
    orderBean.setCompanyId(companyId);
    List<OrderBean> list1 = service.getOrder(orderBean);

    List<OrderBean> list2 = service.getOrderByConditionyunsuan(page,limit,orderBean);

    HashMap<String,Object> tableData =new HashMap<String,Object>();
   /* Long money = service.getMoney();*/
    tableData.put("code", 0);
    tableData.put("msg", "");
    tableData.put("count", list1.size());
    tableData.put("data", list2);
  /*  model.addAttribute("money",money);
    model.addAttribute("count",list2.size());*/
    return tableData;

}

    @RequestMapping("updateddstatus")
    @ResponseBody
    public void updateddstatus(Integer id,Integer status){
        service.updateddstatus(id,status);

    }
//是否选择收货

    @RequestMapping("updateddshouqu")
    @ResponseBody
    public void updateddshouqu(Integer id,Integer status){
        service.updateddshouqu(id,status);

    }

//是否结算
@RequestMapping("updatejiesuan")
@ResponseBody
public void updatejiesuan(Integer id,Integer status){
    service.updatejiesuan(id,status);

}



}
