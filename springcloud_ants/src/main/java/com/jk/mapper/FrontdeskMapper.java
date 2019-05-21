package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrontdeskMapper {

    List<Provinces> findProvinces();

    List<Cities> findCity(int provinceid);

    List<Areas> findArea(int cityid);

    List listData();

    void add(OrderBean orderBean);

    List<AreaData> serviceArea();

    List<OrderBean> companyList();

    AreaData searchArea3();

    AreaData searchArea4(String cityId);
}
