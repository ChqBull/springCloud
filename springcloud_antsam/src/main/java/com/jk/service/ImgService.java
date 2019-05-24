package com.jk.service;

import com.jk.bean.Image;

import java.util.List;
import java.util.Map;

public interface ImgService {
    Map<String, Object> findImgAll(Integer start, Integer pageSize);

    void addImage(Image image);

    void delImage(int imgid);
}
