package com.jk.service.impl;

import com.jk.bean.OrderBean;
import com.jk.mapper.OrderMapper;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper mapper;

    @Override
    public List<OrderBean> queryMyOrder(Integer page, Integer limit, OrderBean orderbean) {
        List<OrderBean> list =  mapper.queryMyOrder((page-1)*limit,limit,orderbean);
        for(OrderBean orderBean:list){
            //根据开始id找到开始市
            if(orderBean.getStatrsquId()!=null &&orderBean.getEndquId()!=null){
                String fahuoxianlu = "";
                String startcity= mapper.queryCityByquId(orderBean.getStatrsquId());
                String endcity= mapper.queryCityByquId(orderBean.getEndquId());
                fahuoxianlu = startcity+"-"+endcity;
                orderBean.setFahuoxianlu(fahuoxianlu);
            }
        }
        return list;
    }
}
