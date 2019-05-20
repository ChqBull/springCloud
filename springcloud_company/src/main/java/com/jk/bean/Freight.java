package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Freight {

    private int id;
    private String orderNum;
    private Date orderTime;
    private double estimateFreight;
    private double serviceCharge;
    private double settlementAmount;
    private int status;
}
