package com.jk.mapper;

import com.jk.bean.MenuTree;
import com.jk.bean.OrderBean;
import com.jk.bean.ZhaoBiaoBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    //我的订单的方法
    List<OrderBean> queryMyOrder(@Param("page")Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderbean);
    //通过区的id获取路线城市的名字
    String queryCityByquId(@Param("statrsquId") Integer statrsquId);

    //用户中心的树
    @Select("select * from UserTree")
    List<MenuTree> findUserTree();
    //查找招标
    List<ZhaoBiaoBean> findZhaoBiao(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("b") ZhaoBiaoBean zhaobiao);
    //批量删除
    @Delete("delete from  zhaobiao where zid in (${ids})")
    void deleteAll(@Param("ids") String ids);
    //回现的方法
    @Select("select * from  zhaobiao where zid = #{id}")
    ZhaoBiaoBean findBootDialogById(@Param("id")String id);
    //修改招标的资料
    void updateZhaobiao(@Param("b")ZhaoBiaoBean zhaobiao);
    //新增招标的资料
    void addZhaobiao(@Param("b")ZhaoBiaoBean zhaobiao);
}
