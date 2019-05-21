package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface AnMapper {



    void addgongsi( @Param("gongso") CompanyModel gongsi);

    @Select("select * from provinces ")
    List<Provinces> fingprovinces();

    @Select(" select * from cities where provinceid=#{id} ")
    List<Cities> findCity(@Param("id") Integer provinceid);

    @Select(" select * from areas where cityid=#{id} ")
    List<Areas> findArea(@Param("id") Integer cityid);
}
