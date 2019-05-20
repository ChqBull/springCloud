package com.jk.mapper;

import com.jk.bean.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    @Select("select * from menu")
    List<Menu> getMenu();
}
