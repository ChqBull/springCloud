package com.jk.service.impl;

import com.jk.mapper.FinancialMapper;
import com.jk.bean.*;
import com.jk.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {
    @Autowired
    FinancialMapper financialMapper;

    @Override
    public HashMap<String, Object> getFinancialStatement(Integer id, FinanciaModel financiaModel, Integer page, Integer limit) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Long i = financialMapper.getFinancialStatementCount(id);
        List<FinanciaModel> li = financialMapper.getFinancialStatement(id,financiaModel,(page-1)*limit,limit);
        map.put("data",li);
        map.put("count",i);
        map.put("code",0);
        return map;
    }

    @Override
    public CashModel goCash(Integer id) {
        CashModel cashModel = new CashModel();
        /*获取当前账户余额*/
        Long Accountbalance = financialMapper.getAccountbalance(id);
        /*获取当前账户正在提现金额*/
        Long sumAmount = financialMapper.goCash(id);
        Long availableAmount = Accountbalance - sumAmount;
         cashModel.setAvailableAmount(availableAmount);
        cashModel.setAccountbBalance(Accountbalance);
        cashModel.setSumAmount(sumAmount);
        return cashModel;
    }

    @Override
    public HashMap<String, Object> getWithdrawalRecords(Integer id, CashModel cashModel, Integer page, Integer limit) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Long sumAmount = financialMapper.getWithdrawalRecordsCount(id);
        List<FinanciaModel> li = financialMapper.getWithdrawalRecords(id,cashModel,(page-1)*limit,limit);
        map.put("data",li);
        map.put("count",sumAmount);
        map.put("code",0);
        return map;
    }

    @Override
    public List<BankCards> getInquireAboutBankCards(Integer id) {
        return financialMapper.getInquireAboutBankCards(id);
    }

    @Override
    public String addCash(CashModel cashModel, Integer id) {
        Integer i = cashModel.getWithdrawalPassword();
        CompanyModel companyModel = financialMapper.judgePassword(id,i);
        if(companyModel == null){
            String msg = "提现密码错误!!!";
            return msg;
        }else{
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(date);
            cashModel.setNewDate(format);
            cashModel.setAuditStatus(1);
            //cashModel.setCompanyId(Integer.valueOf(id));
            financialMapper.addCash(id,cashModel);
            String msg = "提现申请已提交!请耐心等候.";
            return msg;
        }
    }

    @Override
    public HashMap<String , Object> getWithdrawalRecordsEchars(Integer id, CashModel cashModel) {
        HashMap<String , Object> map = new HashMap<>();
        List<String> echarsNames = financialMapper.getWithdrawalRecordsEcharsNames(id);
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i<echarsNames.size() ;i++){
            Integer sum = financialMapper.getWithdrawalRecordsEchars(id,echarsNames.get(i));
            list.add(sum);
        }
        map.put("appDate",echarsNames);
        map.put("values",list);
        return map;
    }

    @Override
    public HashMap<String, Object> getWithdrawalEchars(Integer id) {
        HashMap<String , Object> map = new HashMap<>();
        List<String> echarsNames = financialMapper.getWithdrawalEcharsNames(id);
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i<echarsNames.size() ;i++){
            Integer su = financialMapper.getWithdrawalEchars(id,echarsNames.get(i));
            if(su == null){
                su = 0;
            }
            Integer su2 = financialMapper.getWithdrawalEchars2(id,echarsNames.get(i));
            if(su2 == null){
                su2 = 0;
            }
            Integer sum = su -su2;
            list.add(sum);
        }
        map.put("appDate",echarsNames);
        map.put("values",list);
        return map;
    }

    @Override
    public List<CashModel> getWithdrawalRecordsIop(Integer id) {
        return financialMapper.getWithdrawalRecordsIop(id);
    }

    @Override
    public List<FinanciaModel> getWithdrawalRecordsFinaIop(Integer id) {
        return financialMapper.getWithdrawalRecordsFinaIop(id);
    }
}
