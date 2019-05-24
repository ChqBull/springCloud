package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrontdeskMapper {
    Integer count(Integer companyId);

    List<Wuliuxianlu> list(Integer page, Integer limit, @Param("od") Wuliuxianlu wuliuxianlu, @Param("companyId") Integer companyId);

    List<Provinces> findProvinces();

    List<Cities> findCity(int provinceid);

    List<Areas> findArea(int cityid);

    Wuliuxianlu editLine(String id);

    List listData();

    void add(Wuliuxianlu wuliuxianlu);

    AreaData searchArea(String startplace);

    AreaData searchArea2(String end);

    void deleteData(int id);

    List<Wuliuxianlu> findAll();


    Wuliuxianlu queryOne(Integer id);

    AreaData searchArea5(Integer area1);

    void addLine(Wuliuxianlu wuliuxianlu);

    void addLine2(Wuliuxianlu wuliuxianlu);
}
