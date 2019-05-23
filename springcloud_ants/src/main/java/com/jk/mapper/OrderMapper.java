package com.jk.mapper;

import com.jk.bean.OrderBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    //我的订单的方法
    List<OrderBean> queryMyOrder(@Param("page")Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderbean);
    //通过区的id获取路线城市的名字
    String queryCityByquId(@Param("statrsquId") Integer statrsquId);
}
