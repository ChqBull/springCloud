package com.jk.mapper;


import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrontdeskMapper {


    List<AreaData> serviceArea(Integer statrsquId);

    List<Wuliuxianlu> companyList(@Param("statrsquId") Integer statrsquId, @Param("endquId") Integer endquId);

    AreaData searchArea3(String endAreaId);

    AreaData searchArea4(String startAreaId);
}
