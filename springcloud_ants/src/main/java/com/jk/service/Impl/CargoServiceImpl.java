package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.CargoMapper;
import com.jk.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class CargoServiceImpl implements CargoService {

    @Resource
    CargoMapper cargoMapper;

    @Transactional
    @Override
    public void saveCargo(OrderBean orderBean) {
        //订单号获取
       orderBean.setDdid(System.currentTimeMillis()+"");
       //是否上门提货
        if (orderBean.getQuhuoWay()=="0"){
            orderBean.setQuhuoWay("无需上门取货");
        }else{
            orderBean.setQuhuoWay("需要上门取货");
        }
        //是否送货上门
        if (orderBean.getShGoods()=="0"){
           orderBean.setShGoods("否");
        }else{
            orderBean.setShGoods("是");
        }
        //选择支付方式
        if(orderBean.getZhifuWay()=="0"){
            orderBean.setZhifuWay("已支付");
        }else{
            orderBean.setZhifuWay("代付款");
        }

        cargoMapper.saveCargo(orderBean);
    }

    @Override
    public void addtest(CargoBean addtest) {
        cargoMapper.addtest(addtest);

    }

    @Override
    public List<Provinces> fingprovinces() {
        return cargoMapper.fingprovinces();
    }

    @Override
    public List<Cities> findCity(Integer provinceid) {
        return cargoMapper.findCity(provinceid);
    }

    @Override
    public List<Areas> findArea(Integer cityid) {
        return cargoMapper.findArea(cityid);
    }

    @Override
    public OrderBean findcargoByRoleId() {

        OrderBean list   =  cargoMapper.findcargoByRoleId();
        /*for (int i = 0 ; i < list.size() ;i++){
            String str = "";
            Integer o = list.get(i).getSAreId();
            AreCitPro areCitPro = cargoMapper.getAre(o);
            Integer c = list.get(i).getZAreId();
            AreCitPro areCitPro2 = cargoMapper.getAre(c);
            str += areCitPro.getProvince()+"到"+areCitPro2.getProvince()+"专线";
            list.get(i).setZhuanXian(str);
        }
*/

        return list;
    }

    @Override
    public List<CompanyModel> findCompany() {
        return cargoMapper.findCompany();
    }

    @Override
    public void addDingdan(OrderBean orderBean) {
        orderBean.setDdid(System.currentTimeMillis()+"");
        cargoMapper.addDingdan(orderBean);
    }

    @Override
    public HashMap<String, Object> findOperator(Integer page, Integer limit, OrderBean orderBean) {

//查出来的数据
        List<OrderBean> list2 = cargoMapper.findOperator(page,limit,orderBean);

        HashMap<String,Object> tableData =new HashMap<String,Object>();
        Long money = cargoMapper.findCountOperator();
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", list2.size());
        tableData.put("data", list2);

        return tableData;
    }



 /*   @Override
    public OrderBean  findcargoByRoleId() {
      //  List<OrderBean> list = cargoMapper.findcargoByRoleId();

      *//*  for (int i = 0 ; i < list.size() ;i++){
            String str = "";
            Integer o = list.get(i).getSAreId();
            AreCitPro areCitPro = cargoMapper.getAre(o);
            Integer c = list.get(i).getZAreId();
            AreCitPro areCitPro2 = cargoMapper.getAre(c);
            str += areCitPro.getProvince()+"到"+areCitPro2.getProvince()+"专线";
            list.get(i).setZhuanXian(str);
        }*//*
        return cargoMapper.findcargoByRoleId();
    }*/


}
