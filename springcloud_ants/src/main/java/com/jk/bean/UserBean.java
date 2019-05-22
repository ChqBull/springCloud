package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class UserBean implements Serializable {
    private Integer id;
    private String phoneNumber;//手机号
    private String password;//密码
    private String types;//注册类型
    private String referrer;//推荐人
    private String companyName;//公司名称
    private String qqNumber;//关联的qq
    private String memberId;//推荐人会员ID
    private Integer sex;//性别 1男  2女
    private Integer usertype;//大类型,1发货方,2物流公司
    private String phoneMember;//会员号
    private String name;//真实名字
    private Double money;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;//注册日期
    private Integer remPwd;//记住密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getPhoneMember() {
        return phoneMember;
    }

    public void setPhoneMember(String phoneMember) {
        this.phoneMember = phoneMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRemPwd() {
        return remPwd;
    }

    public void setRemPwd(Integer remPwd) {
        this.remPwd = remPwd;
    }
}
