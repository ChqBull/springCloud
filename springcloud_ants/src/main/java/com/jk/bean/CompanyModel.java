package com.jk.bean;

import lombok.Data;

@Data
public class CompanyModel {
    private Integer companyId;
    private String companyName;//公司名称
    private String companyPassword;//公司登录密码
    private String companyPhone;//公司电话号
    private String companyBalance;//公司账户金额
    private String companyRange;//发货地(路线)
    private Integer withdrawalPassword;//公司提现密码
    private  String    gsjian;//公司简称
    private  String    gsphone;//接单电话
    private  String    gspople;//联系人
    private  String    gsweb;//公司网站
    private  String    gszong;//公司宗旨
    private  String    gsjieshao;//公司介绍
    private  String    address;//详细地址
    private  String    serve;//优势服务行业
    private  String    goodsImg;//上传图片
    private  String    gsadrivs;//办公地址
    
    private  String    gsquancheng;
    private   String  yingye;//营业执照
    private  String  fuzeren;//负责人
    private  String   shuiwu;//税务
    private  String  daolu;//道路

}
