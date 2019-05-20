package com.jk.service;

import com.jk.bean.Areas;
import com.jk.bean.Cities;
import com.jk.bean.HualingTrack;
import com.jk.bean.Provinces;

import java.util.List;

public interface CityService {
    List<Provinces> findProvinces();

    List<Cities> findCity(String provinceid);

    List<Areas> findArea(String cityid);

    List<Cities> cityGroup(String str);

    List<HualingTrack> findHualingTrack(String str);

    List<Cities> findCityById();

    List<HualingTrack> findLineByCityid(HualingTrack hualingTrack);
}
