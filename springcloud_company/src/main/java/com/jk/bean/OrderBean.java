package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderBean implements Serializable {
                private  Integer id; //序号
                private  String   ddid;//订单号
                private  String   xiadanDate;//下单日期
                private  String   startplace;// 开始地点
                private  String   endplace;// 到达地点
                private  String   consigner;// 发货人
                private  String    phone;//电话
                private Date quhuo;//取货时间
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
                private String haveyPrice;//重货价格
                private String lightPrice;//轻货价格
                private String basicPrice;//最低一票价格
                private Integer transtime;//运输时效
                private Integer companyId;
                private String companyName;
                private String gsjian;


               private String tiGoods;//是否上门提货  0否，1是
               private String submitstate;//是否发布  0否，1是
               private String  shGoods;//是否送货上门  0否，1是
               private  String  zfPrice;//支付方式  0发货人支付(现付)，1收货人支付(到付)
               private  String  cityId;//支付方式  0发货人支付(现付)，1收货人支付(到付)

               private  String  shengId;
               private  String  shiId;
               private  String  shengId2;
               private  String  shiId2;

    //收货方
               private  String   shouhuo;// 发货人
               private  String    shphone;//手机号码
               private  String    shlxphone;//电话号码
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
                //private  String    height;///重量
                //private  String    totalvolume;//总体积
                private  String    quhuoDate;//取货时间
                private  String    quhuoWay;//取货方式
                private  String    startDate;//下单时间
                private  String    endDate;//截止时间
                private  String    zhifuWay;//支付方式
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

                private String companyPhone;
                //前台页面加入的字段
                private String fahuoxianlu;

                private Integer  statrsquId;

                private Integer endquId;

}
