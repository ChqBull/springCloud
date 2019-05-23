package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "phoneCount")
public class PhoneCount implements Serializable {
    private String id;
    private String phoneNumber;
    private Integer status;//状态为1  黑名单；  为2 正常
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date blackDate;//时间
    private  String ycCause;//异常原l因

}
