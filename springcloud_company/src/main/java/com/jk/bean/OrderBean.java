package com.jk.bean;

import lombok.Data;


@Data
public class OrderBean  {
                private  String   ddid;//订单号
                private  String   xiadanDate;//下单日期
                private  String   startplace;// 开始地点
                private  String   endplace;// 到达地点
                private  String   consigner;// 发货人
                private  String    phone;//电话
                private Integer id;
                //private  String    height;///重量
                //private  String    totalvolume;//总体积
                private  String    quhuoDate;//取货时间
                private  String    paycount;//支付金额
                private  String    ispay;//是否支付
                private  String   chaxunshu;//下拉查询
                private  String   chaxunreal;//真实查询
                private  String    quhuoWay;//取货方式
                private  String    startDate;//下单时间
                private  String    endDate;//截止时间
                private  String    zhifuWay;//支付方式
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

    private String tiGoods;//是否上门提货  0否，1是
    private String  shGoods;//是否送货上门  0否，1是
    private  String  zfPrice;//支付方式  0发货人支付(现付)，1收货人支付(到付)
    //收货方
    private  String   shouhuo;// 收货人
    private  String    shphone;//手机号码
    private  String    shlxphone;//电话号码
    private   Integer    aid;
    private    String    province;
    private    String    city;
    private    String    area;
      //发货的区id
       private Integer faid;
       private String fahuodiqu;
    //收货的区id
      private  Integer said;
      private String shouhuodiqu;
       private String diqu;

       private String img;
     //受理订单时间
       private String shoulishijian;
       //收货时间
       private String shouhuoshijian;
       //结算时间
       private String jiesuanshijian;
}
