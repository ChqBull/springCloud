package com.jk.mapper;

import com.jk.bean.Freight;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightMapper {

    List<Freight> findFreightAll(@Param("page") int page, @Param("limit") int limit, @Param("freight") Freight freight);

    int count(@Param("freight") Freight freight);

}
