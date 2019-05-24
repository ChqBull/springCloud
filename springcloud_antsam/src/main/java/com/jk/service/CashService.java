package com.jk.service;

import com.jk.bean.CashModel;

import java.util.List;

public interface CashService {
    long getMoney();

    List<CashModel> getOrderByCondition(Integer page, Integer limit);

    void editLine(Integer amount, Integer id, Integer cid);
}
