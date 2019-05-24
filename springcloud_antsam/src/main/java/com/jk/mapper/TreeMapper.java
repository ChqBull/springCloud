package com.jk.mapper;

import com.jk.bean.TreeBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeMapper {

    @Select("select id,text,url as href,pid from treeMain where pid=#{value} ")
    List<TreeBean> findTreeList(Integer id);
}
