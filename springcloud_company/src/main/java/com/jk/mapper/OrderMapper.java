package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper {
   //获取商品
    List<OrderBean> getOrder(@Param("b") OrderBean orderBean);

    List<OrderBean> getOrderByCondition(@Param("page") Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderBean);

    Long getMoney();

    List<OrderBean> getOrdercount();

    OrderBean getOrderById(@Param("id") Integer id);

    AreCitPro getJuTiDiZhi(@Param("o") Integer o);
@Select("select * from  provinces")
     List<Provinces> queryProvinces();
 @Select("select * from  cities where provinceid = #{provinceid}")
 List<Cities> findCity(@Param("provinceid") Integer provinceid);
@Select("select * from  areas where cityid = #{cityid}")
 List<Areas> findArea(@Param("cityid") Integer cityid);
//第一个页面修改状态的方法
 void updateddstatus(@Param("id") Integer id, @Param("status") Integer status);
//收货时间
 void updateddshouqu(@Param("id") Integer id, @Param("status") Integer status);
// 结算时间
 void updatejiesuan(@Param("id") Integer id, @Param("status") Integer status);
@Select("select * from lineTable")
    List<OrderBean> getpoiOrder();
}
