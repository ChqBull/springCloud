package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class HualingTrack {

    private int id;
    private String startCity_id;
    private String endCity_id;
    private Date startTime;
    private Date endTime;
    private String price;
    private int companyId;

    private String startCity;
    private String endCity;
    private String companyName;
}
