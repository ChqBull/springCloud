package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrontdeskMapper {
    Integer count();

    List<OrderBean> list(Integer page, Integer limit, @Param("od") OrderBean orderBean);

    List<Provinces> findProvinces();

    List<Cities> findCity(int provinceid);

    List<Areas> findArea(int cityid);

    OrderBean editLine(Integer id);

    List listData();

    void add(OrderBean orderBean);

    AreaData searchArea(String startplace);

    AreaData searchArea2(String end);

    void deleteData(int id);

    List<OrderBean> findAll();


}
