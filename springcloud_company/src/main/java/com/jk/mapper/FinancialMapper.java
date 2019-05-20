package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialMapper {
    List<FinanciaModel> getFinancialStatement(@Param("id") String id, @Param("financiaModel") FinanciaModel financiaModel, @Param("start") Integer start, @Param("limit") Integer limit);

    Long getFinancialStatementCount(@Param("id") String id);

    Long getWithdrawalRecordsCount(@Param("id") String id);

    List<FinanciaModel> getWithdrawalRecords(@Param("id") String id, @Param("cashModel") CashModel cashModel, @Param("start") Integer start, @Param("limit") Integer limit);

    Long goCash(@Param("id") String id);

    Long getAccountbalance(@Param("id") String id);

    List<BankCards> getInquireAboutBankCards(@Param("id") String id);

    CompanyModel judgePassword(@Param("i") Integer i);

    void addCash(CashModel cashModel);

    List<String> getWithdrawalRecordsEcharsNames(@Param("id") String id);

    Integer getWithdrawalRecordsEchars(@Param("appDate") String applicationDate);

    List<String> getWithdrawalEcharsNames(@Param("id") String id);

    Integer getWithdrawalEchars(@Param("id") String id, @Param("s") String s);

    Integer getWithdrawalEchars2(@Param("id") String id, @Param("s") String s);

    List<CashModel> getWithdrawalRecordsIop(@Param("id") String id);

    List<FinanciaModel> getWithdrawalRecordsFinaIop(@Param("id") String id);
}
