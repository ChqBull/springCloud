package com.jk.service;

import com.jk.bean.*;

import java.util.HashMap;
import java.util.List;

public interface OrderService {


    List<OrderBean> getOrder(OrderBean orderBean);

    List<OrderBean> getOrderByCondition(Integer page, Integer limit, OrderBean orderBean);

    Long getMoney(Integer companyId);

    List<OrderBean> getOrdercount(Integer companyId);

    OrderBean getOrderById(Integer id);
//查找省的方法
    List<Provinces> queryProvinces();
//查找市的方法
    List<Cities> findCity(Integer provinceid);
    //查找县的方法
    List<Areas> findArea(Integer cityid);
    //修改受理订单的方法
    void updateddstatus(Integer id, Integer status);
//是否接货的方法
    void updateddshouqu(Integer id, Integer status);
    //是否结算的方法
    void updatejiesuan(Integer id, Integer status);


  /*  //前段的我的订单方法
    List<OrderBean> queryMyOrder(Integer page, Integer limit, OrderBean order);
    //用户中心的树
    List<MenuTree> findUserTree();
//查找
    HashMap<String, Object> findZhaoBiao(Integer start, Integer pageSize, ZhaoBiaoBean zhaobiao);
//删除
    void deleteAll(String id);
//查找回现的方法
    ZhaoBiaoBean findBootDialogById(String id);
//新增
    void updateZhaobiao(ZhaoBiaoBean zhaobiao);
//修改
    void addZhaobiao(ZhaoBiaoBean zhaobiao);*/
//在途的条件查询
    List<OrderBean> getOrderByConditionzaidu(Integer page, Integer limit, OrderBean orderBean);
//结算的查询
    List<OrderBean> getOrderByConditionyunsuan(Integer page, Integer limit, OrderBean orderBean);

    List<OrderBean> getpoiOrder();
}
