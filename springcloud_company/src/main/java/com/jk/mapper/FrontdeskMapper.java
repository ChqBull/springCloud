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

    AreaData searchArea(Integer startplace);

    AreaData searchArea2(Integer end);

    void deleteData(int id);

    List<OrderBean> findAll();


    OrderBean queryOne(Integer id);

    AreaData searchArea5(Integer area1);

    void addLine(OrderBean orderBean);
}
