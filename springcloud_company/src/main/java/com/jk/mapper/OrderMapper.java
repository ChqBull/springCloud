package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper {
   //获取商品
    List<OrderBean> getOrder(@Param("b") OrderBean orderBean);

    List<OrderBean> getOrderByCondition(@Param("page") Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderBean);

    Long getMoney(@Param("companyId")Integer companyId);

    List<OrderBean> getOrdercount(@Param("companyId")Integer companyId);

    OrderBean getOrderById(@Param("id") Integer id);

    AreCitPro getJuTiDiZhi(@Param("o") Integer o);
@Select("select * from  provinces")
     List<Provinces> queryProvinces();
 @Select("select * from  cities where provinceid = #{provinceid}")
 List<Cities> findCity(@Param("provinceid") Integer provinceid);
@Select("select * from  areas where cityid = #{cityid}")
 List<Areas> findArea(@Param("cityid") Integer cityid);
//第一个页面修改状态的方法
 void updateddstatus(@Param("id") Integer id, @Param("status") Integer status);
//收货时间
 void updateddshouqu(@Param("id") Integer id, @Param("status") Integer status);
// 结算时间
 void updatejiesuan(@Param("id") Integer id, @Param("status") Integer status);


/* //我的订单的方法
    List<OrderBean> queryMyOrder(@Param("page") Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderbean);
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
    ZhaoBiaoBean findBootDialogById(@Param("id") String id);
//修改招标的资料
    void updateZhaobiao(@Param("b") ZhaoBiaoBean zhaobiao);
//新增招标的资料
    void addZhaobiao(@Param("b") ZhaoBiaoBean zhaobiao);*/
//在途的条件查询
    List<OrderBean> getOrderByConditionzaidu(@Param("page") Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderBean);
// 运费的条件查询
    List<OrderBean> getOrderByConditionyunsuan(@Param("page") Integer page, @Param("limit") Integer limit, @Param("b") OrderBean orderBean);
@Select("select * from linetable ")
    List<OrderBean> getpoiOrder();
}
