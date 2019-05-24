package com.jk.mapper;

import com.jk.bean.Image;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgMapper {
    @Select("select * from image limit #{start},#{pageSize}")
    List<Image> findImgAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    void addImage(@Param("i") Image image);

    @Select("select count(*) from image")
    int count();

    @Delete("delete from image where imgid=#{imgid}")
    void delImage(@Param("imgid") int imgid);
}
