package com.jk.bean;

import lombok.Data;

@Data
public class lines {


    private  Integer  lid; //专线id
    private  String   address;//公司地址
    private  String   jianjie;//公司简介
    private  String   lname ;//公司名称
    private  String   ltime;//运输时效--时间
    private  String   weight;//重货
    private  String   light;//轻货
    private  String   endpiao;//最后一票
    private  String   linesnames;//专利名称
    private  String    startcity;//起始城市
    private  String    endcity;//到达城市

}
