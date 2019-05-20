package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.*;
import com.jk.service.CargoService;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CargoController {
    @Autowired
    CargoService cargoService;

    //运营商查询
    @RequestMapping("findOperator")
    @ResponseBody
    public  HashMap<String, Object>findOperator(Integer page ,Integer limit,OrderBean orderBean){

        return      cargoService.findOperator(page,limit,orderBean);

    }


    //新增发货订单

    @RequestMapping("addDingdan")
    @ResponseBody
    public  void addDingdan(OrderBean orderBean){


        cargoService.addDingdan(orderBean);

    }


    //客服
    @RequestMapping(value="testHttp" , produces="application/json;charset=utf-8")
    @ResponseBody
    public Object testHttp(String msg){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //  传参用的集合
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("msg", msg));
        params.add(new BasicNameValuePair("key","free"));
        params.add(new BasicNameValuePair("appid","0"));
        String	paramsStr ="";
        try {
            paramsStr	= EntityUtils.toString(new UrlEncodedFormEntity(params,"UTF-8"));
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        HttpGet httpget = new HttpGet("http://api.qingyunke.com/api.php?"+paramsStr);//调用的连接

        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1;"
                + " Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        httpget.setHeader("Accept", "application/json");

        httpget.setHeader("Accept-Encoding", "gzip, deflate");
        httpget.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30000)  		//设置链接超时的时间3秒钟
                .setSocketTimeout(30000) 		//设置读取超时3秒钟
                .build(); 						//RequestConfig静态方法  setProxy  设置代理


        httpget.setConfig(config);

        CloseableHttpResponse response=null;
        String jsonStr="";
        Object parse=null;
        try {
            response= httpClient.execute(httpget);
            jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            //字符串转对象,前台get出来就可以 {}是对象  []数组
            parse = JSON.parse(jsonStr);
            //把字符串转换为数组,一搬循环
            //JSONArray parseArray = JSONArray.parseArray(jsonStr);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();//关闭
                response.close();//关闭
                httpget.abort();//关闭
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return  parse;
    }




    @RequestMapping("findCompany")
    @ResponseBody
    public List<CompanyModel>findCompany(){


                List<CompanyModel>aaa=       cargoService.findCompany();

        return aaa;
    }


    //查询省

    @RequestMapping("findProvinces")
    @ResponseBody
    public List<Provinces>fingprovinces(){
        return  cargoService.fingprovinces();
    }

    //查询市findCity
    @RequestMapping("findCity")
    @ResponseBody
    public List<Cities>findCity(Integer provinceid){
        return  cargoService.findCity(provinceid);
    }

    //查询区

    @RequestMapping("findArea")
    @ResponseBody
    public List<Areas>findArea(Integer cityid){
        return  cargoService.findArea(cityid);
    }


    //测试
    @RequestMapping("test")
    @ResponseBody
    public  boolean addtest(CargoBean cargoBean){
        try {

            cargoService.addtest(cargoBean);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    //新增
    @RequestMapping("addCargo")
    @ResponseBody
    public  void addCargo(OrderBean orderBean){

        cargoService.saveCargo(orderBean);

    }

  /*  //跳转到在线发货2  zxfh2
    @RequestMapping("zxfh2")
    public  String zxfh2(){
        return "zxfh2";
    }*/

    //跳转到页面
    @RequestMapping("tocargoShow")
    public  String tocarShow(){

        return "cargoShow";
    }


   //跳转到查看订单信息


     @RequestMapping("findMax")
     @ResponseBody
    public  OrderBean findMax() {
       OrderBean orderBean= cargoService.findcargoByRoleId();
     //    System.out.println(orderBean.getCompanyName());
/*
       double a=Double.parseDouble(orderBean.getCargoWeight())*Double.parseDouble(orderBean.getCargoPrice());
       orderBean.setPaycount(a+"");*/
      /* model.addAttribute("cargo",list);
        model.addAttribute("id", id);*/
        return orderBean;
    }

    //弹框的订单查询
    @RequestMapping("tocargodetails")
    public String tocargodetails(String name,Model model) {
        OrderBean orderBean = new OrderBean();
        orderBean.setCompanyName(name);
        model.addAttribute("o",orderBean);
       // System.out.println(name);
        return "cargodetails";
    }

    //订单查询
    @RequestMapping("tocargodetails1")
    public String tocargodetails() {

        return "dick1";
    }
    //跳转到在线发货
    @RequestMapping("tozaixianfahuo")
    public  String tozaixianfahuo(){
        return "zaixianfahuo";
    }



    @RequestMapping("toOperatorDialog")
    public  String toOperatorDialog(){
        return "poeratorDialog";
    }

    //跳转到客服页面
    @RequestMapping("tojiqiren")
    public  String tojiqiren(){
        return "krfu";
    }

}
