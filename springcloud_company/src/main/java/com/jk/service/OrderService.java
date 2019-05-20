package com.jk.service;

import com.jk.bean.Areas;
import com.jk.bean.Cities;
import com.jk.bean.OrderBean;
import com.jk.bean.Provinces;

import java.util.List;

public interface OrderService {


    List<OrderBean> getOrder(OrderBean orderBean);

    List<OrderBean> getOrderByCondition(Integer page, Integer limit, OrderBean orderBean);

    Long getMoney();

    List<OrderBean> getOrdercount();

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

    List<OrderBean> getpoiOrder();
}
