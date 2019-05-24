package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialMapper {
    List<FinanciaModel> getFinancialStatement(@Param("id") Integer id, @Param("financiaModel") FinanciaModel financiaModel, @Param("start") Integer start, @Param("limit") Integer limit);

    Long getFinancialStatementCount(@Param("id") Integer id);

    Long getWithdrawalRecordsCount(@Param("id") Integer id);

    List<FinanciaModel> getWithdrawalRecords(@Param("id") Integer id, @Param("cashModel") CashModel cashModel, @Param("start") Integer start, @Param("limit") Integer limit);

    Long goCash(@Param("id") Integer id);

    Long getAccountbalance(@Param("id") Integer id);

    List<BankCards> getInquireAboutBankCards(@Param("id") Integer id);

    CompanyModel judgePassword(@Param("id") Integer id ,@Param("i") Integer i);

    void addCash(@Param("id") Integer id ,CashModel cashModel);

    List<String> getWithdrawalRecordsEcharsNames(@Param("id") Integer id);

    Integer getWithdrawalRecordsEchars(@Param("id") Integer id, @Param("appDate") String applicationDate);

    List<String> getWithdrawalEcharsNames(@Param("id") Integer id);

    Integer getWithdrawalEchars(@Param("id") Integer id, @Param("s") String s);

    Integer getWithdrawalEchars2(@Param("id") Integer id, @Param("s") String s);

    List<CashModel> getWithdrawalRecordsIop(@Param("id") Integer id);

    List<FinanciaModel> getWithdrawalRecordsFinaIop(@Param("id") Integer id);
}
