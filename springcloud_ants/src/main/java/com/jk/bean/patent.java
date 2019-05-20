package com.jk.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class patent {

          private   Integer pid;//主键id
          private   String   ptype;//认证类型
          private   String  pdate;//注册时间
          private   Integer  pcount;//服务线路
          private   String   contact;//联系人
          private   String  phone;// 联系电话
          private   String  adrive;//联系地址

          @JsonFormat(pattern = " HH:ss:mm")
          @DateTimeFormat(pattern =" HH:ss:mm" )
           private   Date todaytime;//今日发车时间

           @JsonFormat(pattern = " HH:ss:mm")
           @DateTimeFormat(pattern =" HH:ss:mm" )
          private   String  tomtime;//明日发车时间
          private   String    transport;//运输方式
          private   String   price ;//运输价格
          private  String names; //公司名称
}
