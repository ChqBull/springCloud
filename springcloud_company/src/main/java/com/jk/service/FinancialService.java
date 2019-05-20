package com.jk.service;

import com.jk.bean.BankCards;
import com.jk.bean.CashModel;
import com.jk.bean.FinanciaModel;

import java.util.HashMap;
import java.util.List;

public interface FinancialService {
    HashMap<String, Object> getFinancialStatement(String id, FinanciaModel financiaModel, Integer page, Integer limit);

    CashModel goCash(String id);

    HashMap<String, Object> getWithdrawalRecords(String id, CashModel cashModel, Integer page, Integer limit);

    List<BankCards> getInquireAboutBankCards(String id);

    String addCash(CashModel cashModel, String id);

    HashMap<String , Object>  getWithdrawalRecordsEchars(String id, CashModel cashModel);

    HashMap<String, Object> getWithdrawalEchars(String id);

    List<CashModel> getWithdrawalRecordsIop(String id);

    List<FinanciaModel> getWithdrawalRecordsFinaIop(String id);
}
