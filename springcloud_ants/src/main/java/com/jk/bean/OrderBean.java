package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class OrderBean  {
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
                private String tiGoods;//是否上门提货  0否，1是
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
              private  String shiId;
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
               private  String  zfPrice;//支付方式  0发货人支付(现付)，1收货人支付(到付)

                private String gsjian;

                private String submitstate;//是否发布  0否，1是
               private  String  cityId;//支付方式  0发货人支付(现付)，1收货人支付(到付)

               private  String  shengId2;
               private  String  shiId2;

               //重货判断
                private  String   weightStart1;// 重量开始1
                private  String   weightEnd1;// 重量结束1
                private  String   price1;// 重货价格1
                private  String   weightStart2;// 重量开始2
                private  String   weightEnd2;// 重量结束2
                private  String   price2;// 重货价格2
                private  String   weightStart3;// 重量开始3
                private  String   weightEnd3;// 重量结束3
                private  String   price3;// 重货价格3
                private  String   weightStart4;// 重量开始4
                private  String   weightEnd4;// 重量结束4
                private  String   price4;// 重货价格4

}
