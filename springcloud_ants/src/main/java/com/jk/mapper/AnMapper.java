package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface AnMapper {

    @Select("select * from patent where pid=#{id} ")
    patent getzhuanxian(@Param("id") Integer id);

    @Select("select * from lineTable_copy  where start=1")
     List<OrderBean> getyesjilu();


}
