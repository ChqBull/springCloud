package com.jk.service;

import com.jk.bean.*;

import java.util.HashMap;
import java.util.List;

public interface CargoService {
    void saveCargo(OrderBean orderBean);

    void addtest(CargoBean cargoBean);

    List<Provinces> fingprovinces();

    List<Cities> findCity(Integer provinceid);

    List<Areas> findArea(Integer cityid);

    OrderBean  findcargoByRoleId();

    List<CompanyModel> findCompany();

    void addDingdan(OrderBean orderBean);

    HashMap<String, Object> findOperator(Integer page, Integer limit, OrderBean orderBean);



/*
    List<OrderBean> findcargoByRoleId(Integer id);
*/
}
