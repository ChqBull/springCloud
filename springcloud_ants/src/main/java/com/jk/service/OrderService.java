package com.jk.service;

import com.jk.bean.OrderBean;

import java.util.List;

public interface OrderService {
    List<OrderBean> queryMyOrder(Integer page, Integer limit, OrderBean order);
}
