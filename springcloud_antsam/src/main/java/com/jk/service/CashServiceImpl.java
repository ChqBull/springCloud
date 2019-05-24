package com.jk.service;

import com.jk.bean.CashModel;
import com.jk.mapper.CashMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CashServiceImpl  implements CashService {

  @Resource
  CashMapper cashMapper;

  @Override
  public long getMoney() {
    return cashMapper.getMoney();
  }

  @Override
  public List<CashModel> getOrderByCondition(Integer page, Integer limit) {
    return cashMapper.getOrderByCondition((page-1)*limit,limit);
  }

  @Override
  public void editLine(Integer amount, Integer id,Integer cid) {
    if(cid!=null && id!= null && amount!=null){
      cashMapper.updateamount(amount,id);
      cashMapper.updateauditStatus(cid);
     }
    CashModel cashModel = cashMapper.getOrderByCond(cid);
    Date date = new Date();
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    long dateTime = date.getTime();
    String parse = simpleDateFormat.format(date);
    long tradingNumber = dateTime;
    String amount1 = cashModel.getAmount();
    cashMapper.addCaiWuBaoBiao(tradingNumber,parse,amount1,id);
  }
}
