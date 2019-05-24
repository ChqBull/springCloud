package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.OrderMapper;
import com.jk.service.OrderService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

                  Integer o = list.get(i).getStatrsquId();

                  //发货地区
                  if (o != null) {
                        AreCitPro areCitPro = mapper.getJuTiDiZhi(o);
                        fahuodiqu = areCitPro.getProvince() + "-" + areCitPro.getCity() + "-" + areCitPro.getArea();
                        list.get(i).setFahuodiqu(fahuodiqu);
                  }
                  Integer s = list.get(i).getEndquId();
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
      public Long getMoney(Integer companyId) {

            Long   money =  mapper.getMoney(companyId);

            return money;
      }

      @Override
      public List<OrderBean> getOrdercount(Integer companyId) {

            return mapper.getOrdercount(companyId);
      }

      @Override
      public OrderBean getOrderById(Integer id) {
            OrderBean orderbean=  mapper.getOrderById(id);
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



    /*  //我的订单方法
      @Override
      public List<OrderBean> queryMyOrder(Integer page, Integer limit,OrderBean orderbean) {
            List<OrderBean> list =  mapper.queryMyOrder((page-1)*limit,limit,orderbean);
            for(OrderBean orderBean:list){
                  //根据开始id找到开始市
                  if(orderBean.getStatrsquId()!=null &&orderBean.getEndquId()!=null){
                        String fahuoxianlu = "";
                        String startcity= mapper.queryCityByquId(orderBean.getStatrsquId());
                        String endcity= mapper.queryCityByquId(orderBean.getEndquId());
                        fahuoxianlu = startcity+"-"+endcity;
                        orderBean.setFahuoxianlu(fahuoxianlu);
                  }
            }
            return list;
      }
//用户中心的树方法
      @Override
      public List<MenuTree> findUserTree() {

            return  mapper.findUserTree();
      }
  // 表的查询方法
      @Override
      public HashMap<String, Object> findZhaoBiao(Integer start, Integer pageSize, ZhaoBiaoBean zhaobiao) {
            HashMap<String, Object> hashMap = new HashMap<>();
            List<ZhaoBiaoBean> list = mapper.findZhaoBiao(start,pageSize,zhaobiao);
            hashMap.put("total",list.size());
            hashMap.put("rows",list);

            return hashMap;
      }

      @Override
      public void deleteAll(String id) {
           String ids = id.substring(0,id.length()-1);
            mapper.deleteAll(ids);
      }

      @Override
      public ZhaoBiaoBean findBootDialogById(String id) {

            ZhaoBiaoBean zhaobiao= mapper.findBootDialogById(id);
            return zhaobiao;
      }

      @Override
      public void updateZhaobiao(ZhaoBiaoBean zhaobiao) {
            mapper.updateZhaobiao(zhaobiao);
      }

      @Override
      public void addZhaobiao(ZhaoBiaoBean zhaobiao) {
            mapper.addZhaobiao(zhaobiao);
      }
*/

      //在途的条件查询
      @Override
      public List<OrderBean> getOrderByConditionzaidu(Integer page, Integer limit, OrderBean orderBean) {
            int page2 = (page-1)*limit;
            //发货地
            String fahuodiqu = "";
            //收货地
            String shouhuodiqu="";
            List<OrderBean> list = mapper.getOrderByConditionzaidu(page2,limit,orderBean);
            for (int i = 0 ;i < list.size() ; i++) {

                  Integer o = list.get(i).getStatrsquId();

                  //发货地区
                  if (o != null) {
                        AreCitPro areCitPro = mapper.getJuTiDiZhi(o);
                        fahuodiqu = areCitPro.getProvince() + "-" + areCitPro.getCity() + "-" + areCitPro.getArea();
                        list.get(i).setFahuodiqu(fahuodiqu);
                  }
                  Integer s = list.get(i).getEndquId();
                  //收货地区
                  if (s!=null) {
                        AreCitPro areCitPro2 = mapper.getJuTiDiZhi(s);
                        shouhuodiqu = areCitPro2.getProvince() + "-" + areCitPro2.getCity() + "-" + areCitPro2.getArea();
                        list.get(i).setShouhuodiqu(shouhuodiqu);
                  }
            }
            return list;
      }
   //运算的条查
      @Override
      public List<OrderBean> getOrderByConditionyunsuan(Integer page, Integer limit, OrderBean orderBean) {
            int page2 = (page-1)*limit;
            //发货地
            String fahuodiqu = "";
            //收货地
            String shouhuodiqu="";
            List<OrderBean> list = mapper.getOrderByConditionyunsuan(page2,limit,orderBean);
            for (int i = 0 ;i < list.size() ; i++) {

                  Integer o = list.get(i).getStatrsquId();

                  //发货地区
                  if (o != null) {
                        AreCitPro areCitPro = mapper.getJuTiDiZhi(o);
                        fahuodiqu = areCitPro.getProvince() + "-" + areCitPro.getCity() + "-" + areCitPro.getArea();
                        list.get(i).setFahuodiqu(fahuodiqu);
                  }
                  Integer s = list.get(i).getEndquId();
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
      public List<OrderBean> getpoiOrder() {
            return mapper.getpoiOrder();
      }


}
