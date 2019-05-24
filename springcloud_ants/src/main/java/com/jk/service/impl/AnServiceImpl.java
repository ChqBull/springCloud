package com.jk.service.impl;

import com.jk.bean.OrderBean;
import com.jk.bean.zhuanxian;
import com.jk.mapper.AnMapper;
import com.jk.service.AnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnServiceImpl implements  AnService{

    @Resource
    AnMapper anMapper;
    @Override
    public zhuanxian getzhuanxian(Integer id) {

        return anMapper.getzhuanxian(id);
    }

    @Override
    public List<OrderBean> getyesjilu(){
        List<OrderBean>list=anMapper.getyesjilu();
        for (OrderBean orderBeans : list) {
            String phone = orderBeans.getPhone();
            String substring = phone.substring(0,7);
            orderBeans.setPhone(substring+"****");

        }
        return list;
    }

    @Override
    public Integer findxianlucount(int companyId) {
        return anMapper.findxianlucount(companyId);
    }


}
