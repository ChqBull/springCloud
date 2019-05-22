package com.jk.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "phoneCount")
public class PhoneCount implements Serializable {
    private String id;
    private String phoneNumber;
    private Date blackDate;
    private Integer status;//状态为1  黑名单；  为2 正常

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBlackDate() {
        return blackDate;
    }

    public void setBlackDate(Date blackDate) {
        this.blackDate = blackDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
