package com.jk.bean;





public class UserBean  {
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public Integer getPhoneMember() {
        return phoneMember;
    }

    public void setPhoneMember(Integer phoneMember) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getRemPwd() {
        return remPwd;
    }

    public void setRemPwd(Integer remPwd) {
        this.remPwd = remPwd;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
