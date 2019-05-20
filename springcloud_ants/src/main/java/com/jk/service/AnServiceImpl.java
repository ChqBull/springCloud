package com.jk.service;

import com.jk.bean.*;
import com.jk.mapper.AnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnServiceImpl  implements  AnService{

    @Resource
    AnMapper anMapper;
    @Override
    public patent getzhuanxian(Integer id) {

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


}
