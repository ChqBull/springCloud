package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CargoMapper {

    void saveCargo(OrderBean orderBean);

    @Insert(" insert into cargoTable  (test)values(#{test}) ")
    void addtest(CargoBean addtest);

    @Select("select * from provinces ")
    List<Provinces> fingprovinces();

    @Select(" select * from cities where provinceid=#{0} ")
    List<Cities> findCity(Integer provinceid);

    @Select(" select * from areas where cityid=#{0} ")
    List<Areas> findArea(Integer cityid);

    OrderBean findcargoByRoleId();

    @Select(" select * from t_company  ")
    List<CompanyModel> findCompany();

    void addDingdan(OrderBean orderBean);

    List<OrderBean> findOperator(@Param("page") Integer page, @Param("limit") Integer limit, @Param("orderBean") OrderBean orderBean);

    @Select(" select count(*) from  lineTable ")
    Long findCountOperator();

    void addDingdan(@Param("id") Integer id, OrderBean orderBean);

    /*   AreCitPro getAre(@Param("o") Integer o);*/
}
