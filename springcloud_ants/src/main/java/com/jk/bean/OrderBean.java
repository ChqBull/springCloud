package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderBean implements Serializable {
                private  String   ddid;//订单号
                private  String   xiadanDate;//下单日期
                private  String   startplace;// 开始地点
                private  String   endplace;// 到达地点
                private  String   consigner;// 发货人
                private  String    phone;//电话
                private  Date quhuo;//取货时间
                private  String    paycount;//支付金额
                private  String    ispay;//是否支付
                private  String   chaxunshu;//下拉查询
                private  String   chaxunreal;//真实查询
      //货物信息
                private String cargoName;//货物名称
                private String cargoCount;//货物件数
                private String cargoType;//包装类型
                private String cargoWeight;//货物重量
                private String cargoBulk;//货物体积
                private String cargoZweight;//总重量
                private String cargoZbulk;//总体积
                private String cargoZcount;//总件数
                private String cargoImg;//货物照片
                private String fahuoExplain;//发货说明
                private String  cargoPrice;//货物单价

               private String quhuoWay;//是否上门提货  0否，1是
               private String  shGoods;//是否送货上门  0否，1是
               private  String  zhifuWay;//支付方式  0发货人支付(现付)，1收货人支付(到付)
      //收货方
               private  String   shouhuo;// 收货人
               private  String    shphone;//手机号码
               private  String    shlxphone;//电话号码a
               private  String  dzxq;//地址详情
                private Integer sAreId;//始发地
                private Integer zAreId;//终点id
                private String zhuanXian;

  //地区
              private  Integer shengId;
              private Integer shiId;
              private  Integer quId;
             private  String provinceName;
             private  String cityName;
             private  String areaName;

    //物流公司关联
           private  Integer companyId;
           private  String companyName;

           private Integer statrsquId;
           private Integer endquId;


            private String haveyPrice;//重货价格
            private String lightPrice;//轻货价格
            private String basicPrice;//最低一票价格
            private Integer transtime;//运输时效
}
