package com.jk.service;

import com.jk.bean.Image;
import com.jk.mapper.ImgMapper;
import com.jk.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    @Override
    public Map<String, Object> findImgAll(Integer start, Integer pageSize) {
        Map<String,Object> map=new HashMap<>();
        int count=imgMapper.count();
        List<Image> list = imgMapper.findImgAll(start,pageSize);
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public void addImage(Image image) {
        imgMapper.addImage(image);
    }

    @Override
    public void delImage(int imgid) {
        imgMapper.delImage(imgid);
    }
}
