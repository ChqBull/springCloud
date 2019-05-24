package com.jk.service.impl;

import com.jk.bean.MenuTree;
import com.jk.bean.OrderBean;
import com.jk.bean.ZhaoBiaoBean;
import com.jk.mapper.OrderMapper;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    //用户中心的树方法
    @Override
    public List<MenuTree> findUserTree() {

        return  mapper.findUserTree();
    }
    // 表的查询方法
    @Override
    public HashMap<String, Object> findZhaoBiao(Integer start, Integer pageSize, ZhaoBiaoBean zhaobiao) {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<ZhaoBiaoBean> list = mapper.findZhaoBiao(start,pageSize,zhaobiao);
        hashMap.put("total",list.size());
        hashMap.put("rows",list);

        return hashMap;
    }

    @Override
    public void deleteAll(String id) {
        String ids = id.substring(0,id.length()-1);
        mapper.deleteAll(ids);
    }

    @Override
    public ZhaoBiaoBean findBootDialogById(String id) {

        ZhaoBiaoBean zhaobiao= mapper.findBootDialogById(id);
        return zhaobiao;
    }

    @Override
    public void updateZhaobiao(ZhaoBiaoBean zhaobiao) {
        mapper.updateZhaobiao(zhaobiao);
    }

    @Override
    public void addZhaobiao(ZhaoBiaoBean zhaobiao) {
        mapper.addZhaobiao(zhaobiao);
    }
}
