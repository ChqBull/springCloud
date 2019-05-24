package com.jk.controller;

import com.jk.bean.Image;
import com.jk.service.ImgService;
import com.jk.utils.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("img")
public class ImgController {

    @Autowired
    private ImgService imgService;

    @RequestMapping("findImgAll")
    @ResponseBody
    public Map<String, Object> findImgAll(Integer start, Integer pageSize){
        return imgService.findImgAll(start,pageSize);
    }

    //上传
    @RequestMapping("imgUpload")
    @ResponseBody
    public  HashMap<String,Object> imgUpload(MultipartFile goodsImg){
        String filename = goodsImg.getOriginalFilename();
        System.out.println(filename);
        HashMap<String, Object> map = new HashMap<>();
        try {
            if (goodsImg != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(goodsImg.getBytes());
                    os.close();
                    goodsImg.transferTo(newFile);
                    // 上传到OSS
                    String uploadUrl = AliyunOSSUtil.upLoad(newFile);
                    map.put("imgId",uploadUrl);
                    return  map;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        map.put("imgId","");
        return  map;
    }

    //下载
    /**
     * 通过文件名下载文件
     */


    @RequestMapping("addImage")
    @ResponseBody
    public void addImage(Image image){
        imgService.addImage(image);
    }

    @RequestMapping("delImage")
    @ResponseBody
    public void delImage(int imgid){
        imgService.delImage(imgid);
    }


}
