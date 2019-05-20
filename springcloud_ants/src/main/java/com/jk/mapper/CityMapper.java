package com.jk.mapper;

import com.jk.bean.Areas;
import com.jk.bean.Cities;
import com.jk.bean.HualingTrack;
import com.jk.bean.Provinces;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {

    @Select("select * from provinces")
    List<Provinces> findProvinces();

    @Select("select * from cities where provinceid=#{provinceid}")
    List<Cities> findCity(String provinceid);

    @Select("select * from areas where cityid=#{cityid}")
    List<Areas> findArea(String cityid);

    List<Cities> cityGroup(@Param("str") String str);

    List<HualingTrack> findHualingTrack(@Param("str") String str);

    @Select("select c.cityid,c.city from hualing_track ht,cities c where ht.startCity_id=c.cityid group by c.id")
    List<Cities> findCityById();


    List<HualingTrack> findLineByCityid(@Param("h") HualingTrack hualingTrack);
}
