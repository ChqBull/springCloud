package com.jk.service;

import com.jk.bean.BankCards;
import com.jk.bean.CashModel;
import com.jk.bean.FinanciaModel;

import java.util.HashMap;
import java.util.List;

public interface FinancialService {
    HashMap<String, Object> getFinancialStatement(Integer id, FinanciaModel financiaModel, Integer page, Integer limit);

    CashModel goCash(Integer id);

    HashMap<String, Object> getWithdrawalRecords(Integer id, CashModel cashModel, Integer page, Integer limit);

    List<BankCards> getInquireAboutBankCards(Integer id);

    String addCash(CashModel cashModel, Integer id);

    HashMap<String , Object>  getWithdrawalRecordsEchars(Integer id, CashModel cashModel);

    HashMap<String, Object> getWithdrawalEchars(Integer id);

    List<CashModel> getWithdrawalRecordsIop(Integer id);

    List<FinanciaModel> getWithdrawalRecordsFinaIop(Integer id);
}
