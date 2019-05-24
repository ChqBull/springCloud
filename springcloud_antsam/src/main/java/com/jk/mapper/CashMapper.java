package com.jk.mapper;

import com.jk.bean.CashModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CashMapper {
    @Select("select count(*) from t_cash where auditStatus = '1'  ")
    long getMoney();
    @Select("select * from  t_cash c ,t_company t where c.companyId = t.companyId and c.auditStatus = '1' Limit #{page},#{limit}")
    List<CashModel> getOrderByCondition(@Param("page") Integer page, @Param("limit") Integer limit);
     @Update("update t_company set companyBalance=companyBalance-#{amount} where companyId=#{id}")
    void updateamount(@Param("amount") Integer amount, @Param("id") Integer id);
    @Update("update t_cash set auditStatus =2 where cmId =#{cid}")
    void updateauditStatus(@Param("cid") Integer cid);
    @Select("select * from  t_cash where cmId = #{cid}")
    CashModel getOrderByCond(@Param("cid") Integer cid);
    void addCaiWuBaoBiao(@Param("tradingNumber") long tradingNumber,@Param("s") String s,@Param("amount1") String amount1,@Param("id") Integer id);
}
