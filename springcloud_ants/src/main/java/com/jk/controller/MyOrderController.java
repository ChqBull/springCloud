package com.jk.controller;

import com.jk.bean.MenuTree;
import com.jk.bean.OrderBean;
import com.jk.bean.TreeNoteUtil;
import com.jk.bean.ZhaoBiaoBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class MyOrderController {
        @Autowired
       OrderService service;

       @RequestMapping("MyOrderPage")
       public String MyOrderPage(){

            return "MyOrderPage";
        }



      @RequestMapping("queryMyOrder")
      @ResponseBody
     public HashMap<String,Object>queryMyOrder(Integer page, Integer limit, OrderBean order){
          HashMap<String, Object> hashMap = new HashMap<>();
         List<OrderBean> list = service.queryMyOrder(page,limit,order);
          hashMap.put("code", 0);
          hashMap.put("msg", "");
          hashMap.put("count", list.size());
          hashMap.put("data", list);
          return hashMap;
      }

    //跳转到个人中心的树
    @RequestMapping("userTree")
    public String userTree(){

        return "toUserTree";
    }
    @RequestMapping("findUserTree")
    @ResponseBody
    public List<MenuTree> findUserTree(){
        List<MenuTree> list = service.findUserTree();
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }

    //招商管理的页面
    @RequestMapping("zhaoShangPage")
    public String zhaoShangPage(){

        return "zhaoShangPage";
    }
    //用户中心的页面
    @RequestMapping("yonghuPage")
    public String yonghuPage(){
        return "yonghuPage";
    }
    //招商管理的查询

    @RequestMapping("findZhaoBiao")
    @ResponseBody
    public HashMap<String,Object>findZhaoBiao(Integer start, Integer pageSize, ZhaoBiaoBean zhaobiao){
        HashMap<String, Object> zhaoBiao = service.findZhaoBiao(start, pageSize, zhaobiao);
        return zhaoBiao;
    }
    //删除

    @RequestMapping("deleteAll")
    @ResponseBody
    public void deleteAll(String zid){
        service.deleteAll(zid);
    }

    //编辑的方法
    @RequestMapping("findBootDialogById")
    public String findBootDialogById(String zid, Model model) {
        //如果suppid不是空的，就走修改的方法
        if(zid!=null && Integer.parseInt(zid)>0){
            ZhaoBiaoBean zhaobiao =service.findBootDialogById(zid);
            model.addAttribute("z", zhaobiao);
        }
        //如果是空的直接进页面
        return "zhaoShangBianJi";
    }
    //提交按钮的方法

    @RequestMapping("saveMongo")
    @ResponseBody
    public String saveMongo(ZhaoBiaoBean zhaobiao){
        //如果id不是空的，就走修改的方法
        if(zhaobiao.getZid()!=null ){
            service.updateZhaobiao(zhaobiao);
        }
        else{
            service.addZhaobiao(zhaobiao);
        }
        return null;
    }

}
