package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface AnMapper {


    zhuanxian getzhuanxian(@Param("id") Integer id);

    @Select("select * from lineTable_copy  where ispay='是'")
     List<OrderBean> getyesjilu();

    @Select("select count(*) from hualing_track where company_id=#{id}")
    Integer findxianlucount(@Param("id") int companyid);
}
