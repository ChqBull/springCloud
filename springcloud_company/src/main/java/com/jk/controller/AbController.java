package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.AnService;
import com.jk.util.AliyunOSSUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

@Controller
public class AbController {

    @Resource
    AnService anService;


    @RequestMapping("gongsi")
    public String getinfo(){

        return "gongsi";
    }

    @RequestMapping("zhaopian")
    public String getzhaopian(){
        return "zhaopian";
    }

    @RequestMapping("addgongsi")
    @ResponseBody
    public void addgongsi(CompanyModel gongsi , String check, HttpSession session){
        gongsi.setCompanyId(1);
        gongsi.setServe(check);
        anService.addgongsi(gongsi);
    }
    //查询省

    @RequestMapping("findProvinces")
    @ResponseBody
    public List<Provinces>fingprovinces(){
        return  anService.fingprovinces();
    }

    //查询市findCity
    @RequestMapping("findCity")
    @ResponseBody
    public List<Cities>findCity(Integer provinceid){
        return  anService.findCity(provinceid);
    }

    //查询区

    @RequestMapping("findArea")
    @ResponseBody
    public List<Areas>findArea(Integer cityid){

        return  anService.findArea(cityid);
    }

    @RequestMapping("imgUpload")
    @ResponseBody
    public  HashMap<String,Object> imgUpload( MultipartFile goodsImg,String msg){

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
}
