package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface CityService {
    List<Provinces> findProvinces();

    List<Cities> findCity(String provinceid);

    List<Areas> findArea(String cityid);

    List<Cities> cityGroup(String str);

    List<HualingTrack> findHualingTrack(String str);

    List<Cities> findCityById();

    List<HualingTrack> findLineByCityid(HualingTrack hualingTrack);

    List<Order> findOrder();

}
