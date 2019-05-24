package com.jk.service;

import com.jk.bean.MenuTree;
import com.jk.bean.OrderBean;
import com.jk.bean.ZhaoBiaoBean;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    List<OrderBean> queryMyOrder(Integer page, Integer limit, OrderBean order);

    //用户中心的树
    List<MenuTree> findUserTree();
    //查找
    HashMap<String, Object> findZhaoBiao(Integer start, Integer pageSize, ZhaoBiaoBean zhaobiao);
    //删除
    void deleteAll(String id);
    //查找回现的方法
    ZhaoBiaoBean findBootDialogById(String id);
    //新增
    void updateZhaobiao(ZhaoBiaoBean zhaobiao);
    //修改
    void addZhaobiao(ZhaoBiaoBean zhaobiao);
}
