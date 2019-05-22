package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class HualingTrack {

    private int id;
    private String startCity_id;
    private String endCity_id;
    private String startTime;
    private String endTime;
    private String price;
    private int companyId;

    private String startCity;
    private String endCity;
    private String companyName;
}
