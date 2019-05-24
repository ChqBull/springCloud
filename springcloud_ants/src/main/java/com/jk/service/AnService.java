package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface AnService {
    zhuanxian getzhuanxian(Integer id);

    List<OrderBean> getyesjilu();


    Integer findxianlucount(int companyid);
}
