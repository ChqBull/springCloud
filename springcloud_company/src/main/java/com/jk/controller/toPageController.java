package com.jk.controller;

import com.jk.bean.CompanyModel;
import com.jk.bean.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class toPageController {
     @Autowired
     private OrderService service;
    @RequestMapping("orderPage")
    public String  page(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
        Integer companyId = companyModel.getCompanyId();
        List<OrderBean> list1 = service.getOrdercount(companyId);
        Long money = service.getMoney(companyId);
        model.addAttribute("money",money);
        model.addAttribute("count",list1.size());

        return "orderPage";
    }

    @RequestMapping("todetailsPage")
    public String todetails(Integer id,Model model){
       OrderBean  order = service.getOrderById(id);
       if(order.getShoulishijian()!=null && order.getShoulishijian().length()>0){
           model.addAttribute("o",order);
       }else{
           order.setShoulishijian("尚未受理服务");
           model.addAttribute("o",order);
       }

                  return "todetailsPage";
    }
//跳的第二个页面
    @RequestMapping("yunshuzaitu")
    public String  yunshuzaitu(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
        Integer companyId = companyModel.getCompanyId();
        List<OrderBean> list1 = service.getOrdercount(companyId);
        Long money = service.getMoney(companyId);
        model.addAttribute("money",money);
        model.addAttribute("count",list1.size());

        return "yunshuzaitu";
    }

    @RequestMapping("tozaituPage")
    public String tozaituPage(Integer id,Model model){
        OrderBean  order = service.getOrderById(id);
        if(order.getShoulishijian().length()>0){
            if(order.getShouhuoshijian()!=null){
                model.addAttribute("o",order);
            }else{
                order.setShouhuoshijian("尚未选择收货");
                model.addAttribute("o",order);
            }
        }else {

            order.setShoulishijian("尚未选择受理服务");
            order.setShouhuoshijian("尚未选择收货");
            model.addAttribute("o",order);
        }


        return "tozaituPage";
    }

    //跳的第三个页面
    @RequestMapping("yunsuanPage")
    public String  yunsuanPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());
        Integer companyId = companyModel.getCompanyId();
        List<OrderBean> list1 = service.getOrdercount(companyId);
        Long money = service.getMoney(companyId);
        model.addAttribute("money",money);
        model.addAttribute("count",list1.size());

        return "yunsuanPage";
    }

    @RequestMapping("toyunsuanPage")
    public String toyunsuanPage(Integer id,Model model){
        OrderBean  order = service.getOrderById(id);
              if(order.getShoulishijian()!=null&&order.getShoulishijian().length()>0){
                    if(order.getShouhuoshijian()!=null&&order.getShouhuoshijian().length()>0 ){
                         if(order.getJiesuanshijian()!=null&&order.getJiesuanshijian().length()>0){
                             model.addAttribute("o",order);
                         }else {
                             order.setJiesuanshijian("用户没有结算，系统将于俩天后自动结算");
                             model.addAttribute("o",order);
                         }

                    }else{
                        order.setShouhuoshijian("尚未选择收货");
                        order.setJiesuanshijian("用户没有结算，系统将于俩天后自动结算");
                        model.addAttribute("o",order);
                    }

              }else{
                  order.setShoulishijian("尚未选择受理");
                  order.setShouhuoshijian("尚未选择收货");
                  order.setJiesuanshijian("用户没有结算，系统将于俩天后自动结算");
                  model.addAttribute("o",order);
              }
        return "toyunsuanPage";
    }
}
