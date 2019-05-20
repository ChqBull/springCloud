package com.jk.bean;

import lombok.Data;

@Data
public class CompanyModel {
    private Integer companyId;
    private String companyName;
    private String companyPassword;
    private String companyPhone;
    private String companyBalance;
    private String companyRange;
    private Integer withdrawalPassword;
    private  String    gsjian;//公司简称
    private  String    gsphone;//接单电话
    private  String    gspople;//联系人
    private  String    gsweb;//公司网站
    private  String    gszong;//公司宗旨
    private  String    gsjieshao;//公司介绍
    private  String    address;//详细地址
    private  String    serve;//优势服务行业
    private  String    goodsImg;//上传图片

}
