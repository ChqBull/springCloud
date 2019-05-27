package com.jk.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {
    private Integer id;
    private String phoneNumber;//手机号
    private String password;//密码
    private String types;//注册类型
    private String referrer;//推荐人
    private String companyName;//公司名称
    private Integer companyId;//公司名称
    private String qqNumber;//关联的qq
    private String memberId;//推荐人会员ID
    private Integer sex;//性别 1男  2女
    private Integer usertype;//大类型,1发货方,2物流公司
    private Integer phoneMember;//会员号
    private String name;//真实名字
    private Double money;
    private String createTime;//注册日期
    private Integer remPwd;//记住密码
    private String lastTime;//登录时间
}
