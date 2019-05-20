package com.jk.bean;

import lombok.Data;

@Data
public class cargo {

        private  Integer  cid;
        private  String    cname;//联系人
        private   String  phone;//手机号
        private  String  cargoname;//货物名称
        private  String  kilo;//货物信息：公斤
        private  String stere ;//信息：立方米
        private   Integer  tihuo ;//是否上门提货
        private  String  adrivs;//地区详细地址
        private  Integer songhuo;//是否送货上门
        private  Integer   zhifu;//支付方式
        private  String qita;//其他说明
}
