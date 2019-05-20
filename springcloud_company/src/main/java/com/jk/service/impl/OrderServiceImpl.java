package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.OrderMapper;
import com.jk.service.OrderService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
      @Autowired
      private OrderMapper  mapper;


      @Override
      public List<OrderBean> getOrder(OrderBean orderBean) {
            List<OrderBean>list = mapper.getOrder(orderBean);
            return list;
      }

      @Override
      public List<OrderBean> getOrderByCondition(Integer page, Integer limit, OrderBean orderBean) {
            int page2 = (page-1)*limit;
            //发货地
            String fahuodiqu = "";
            //收货地
            String shouhuodiqu="";
            List<OrderBean> list = mapper.getOrderByCondition(page2,limit,orderBean);
            for (int i = 0 ;i < list.size() ; i++) {

                  Integer o = list.get(i).getFaid();

                  //发货地区
                  if (o != null) {
                        AreCitPro areCitPro = mapper.getJuTiDiZhi(o);
                        fahuodiqu = areCitPro.getProvince() + "-" + areCitPro.getCity() + "-" + areCitPro.getArea();
                        list.get(i).setFahuodiqu(fahuodiqu);
                  }
                  Integer s = list.get(i).getSaid();
                  //收货地区
                  if (s!=null) {
                        AreCitPro areCitPro2 = mapper.getJuTiDiZhi(s);
                        shouhuodiqu = areCitPro2.getProvince() + "-" + areCitPro2.getCity() + "-" + areCitPro2.getArea();
                        list.get(i).setShouhuodiqu(shouhuodiqu);
                  }
            }
            return list;
      }

      @Override
      public Long getMoney() {

            Long   money =  mapper.getMoney();

            return money;
      }

      @Override
      public List<OrderBean> getOrdercount() {

            return mapper.getOrdercount();
      }

      @Override
      public OrderBean getOrderById(Integer id) {
            OrderBean orderbean=   mapper.getOrderById(id);
            //发货地
            String fahuodiqu = "";
            //收货地
            String shouhuodiqu="";


            Integer o = orderbean.getFaid();

            //发货地区
            if (o != null) {
                  AreCitPro areCitPro = mapper.getJuTiDiZhi(o);
                  fahuodiqu = areCitPro.getProvince() + "-" + areCitPro.getCity() + "-" + areCitPro.getArea();
                  orderbean.setFahuodiqu(fahuodiqu);
            }
            Integer s = orderbean.getSaid();
            //收货地区
            if (s!=null) {
                  AreCitPro areCitPro2 = mapper.getJuTiDiZhi(s);
                  shouhuodiqu = areCitPro2.getProvince() + "-" + areCitPro2.getCity() + "-" + areCitPro2.getArea();
                  orderbean.setShouhuodiqu(shouhuodiqu);
            }
            return orderbean;
      }

      @Override
      public List<Provinces> queryProvinces() {

            return mapper.queryProvinces();
      }

      @Override
      public List<Cities> findCity(Integer provinceid) {

            return mapper.findCity(provinceid);
      }

      @Override
      public List<Areas> findArea(Integer cityid) {


            return mapper.findArea(cityid);
      }

      @Override
      public void updateddstatus(Integer id,Integer status) {
         //直接修改订单状态，受理订单为1 拒绝受理为2
            //
            mapper.updateddstatus(id,status);

      }

      @Override
      public void updateddshouqu(Integer id, Integer status) {


            mapper.updateddshouqu(id,status);
      }

      @Override
      public void updatejiesuan(Integer id, Integer status) {
            mapper.updatejiesuan(id,status);
      }
}
