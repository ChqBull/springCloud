package com.jk.bean;




import java.io.Serializable;
import java.util.Date;


public class OrderBean implements Serializable {
                private  Integer id; //序号
                private  String   ddid;//订单号
                private  String   xiadanDate;//下单日期
                private  String   startplace;// 开始地点
                private  String   endplace;// 到达地点
                private  String   consigner;// 发货人
                private  String    phone;//电话
                private Date quhuo;//取货时间
                private  String    paycount;//支付金额
                private  String    ispay;//是否支付
                private  String   chaxunshu;//下拉查询
                private  String   chaxunreal;//真实查询
      //货物信息
                private String cargoName;//货物名称
                private String cargoCount;//货物件数
                private String cargoType;//包装类型
                private String cargoWeight;//货物重量
                private String cargoBulk;//货物体积
                private String cargoZweight;//总重量
                private String cargoZbulk;//总体积
                private String cargoZcount;//总件数
                private String cargoImg;//货物照片
                private String fahuoExplain;//发货说明
                private String  cargoPrice;//货物单价
                private String haveyPrice;//重货价格
                private String lightPrice;//轻货价格
                private String basicPrice;//最低一票价格
                private Integer transtime;//运输时效
                private Integer companyId;
                private String companyName;
                private String gsjian;

                 private Integer statrsquId;
                 private Integer endquId;
               private String tiGoods;//是否上门提货  0否，1是
               private String submitstate;//是否发布  0否，1是
               private String  shGoods;//是否送货上门  0否，1是
               private  String  zfPrice;//支付方式  0发货人支付(现付)，1收货人支付(到付)
               private  String  cityId;//支付方式  0发货人支付(现付)，1收货人支付(到付)

               private  String  shengId;
               private  String  shiId;
               private  String  shengId2;
               private  String  shiId2;


    public Integer getStatrsquId() {
        return statrsquId;
    }

    public void setStatrsquId(Integer statrsquId) {
        this.statrsquId = statrsquId;
    }

    public Integer getEndquId() {
        return endquId;
    }

    public void setEndquId(Integer endquId) {
        this.endquId = endquId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGsjian() {
        return gsjian;
    }

    public void setGsjian(String gsjian) {
        this.gsjian = gsjian;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getShengId2() {
        return shengId2;
    }

    public void setShengId2(String shengId2) {
        this.shengId2 = shengId2;
    }

    public String getShiId2() {
        return shiId2;
    }

    public void setShiId2(String shiId2) {
        this.shiId2 = shiId2;
    }

    public String getShengId() {
        return shengId;
    }

    public void setShengId(String shengId) {
        this.shengId = shengId;
    }

    public String getShiId() {
        return shiId;
    }

    public void setShiId(String shiId) {
        this.shiId = shiId;
    }

    //收货方
               private  String   shouhuo;// 发货人
               private  String    shphone;//手机号码
               private  String    shlxphone;//电话号码


    //重货判断
                private  String   weightStart1;// 重量开始1
                private  String   weightEnd1;// 重量结束1
                private  String   price1;// 重货价格1
                private  String   weightStart2;// 重量开始2
                private  String   weightEnd2;// 重量结束2
                private  String   price2;// 重货价格2
                private  String   weightStart3;// 重量开始3
                private  String   weightEnd3;// 重量结束3
                private  String   price3;// 重货价格3
                private  String   weightStart4;// 重量开始4
                private  String   weightEnd4;// 重量结束4
                private  String   price4;// 重货价格4

    public String getWeightStart1() {
        return weightStart1;
    }

    public void setWeightStart1(String weightStart1) {
        this.weightStart1 = weightStart1;
    }

    public String getWeightEnd1() {
        return weightEnd1;
    }

    public void setWeightEnd1(String weightEnd1) {
        this.weightEnd1 = weightEnd1;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getWeightStart2() {
        return weightStart2;
    }

    public void setWeightStart2(String weightStart2) {
        this.weightStart2 = weightStart2;
    }

    public String getWeightEnd2() {
        return weightEnd2;
    }

    public void setWeightEnd2(String weightEnd2) {
        this.weightEnd2 = weightEnd2;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getWeightStart3() {
        return weightStart3;
    }

    public void setWeightStart3(String weightStart3) {
        this.weightStart3 = weightStart3;
    }

    public String getWeightEnd3() {
        return weightEnd3;
    }

    public void setWeightEnd3(String weightEnd3) {
        this.weightEnd3 = weightEnd3;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getWeightStart4() {
        return weightStart4;
    }

    public void setWeightStart4(String weightStart4) {
        this.weightStart4 = weightStart4;
    }

    public String getWeightEnd4() {
        return weightEnd4;
    }

    public void setWeightEnd4(String weightEnd4) {
        this.weightEnd4 = weightEnd4;
    }

    public String getPrice4() {
        return price4;
    }

    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdid() {
        return ddid;
    }

    public void setDdid(String ddid) {
        this.ddid = ddid;
    }

    public String getXiadanDate() {
        return xiadanDate;
    }

    public void setXiadanDate(String xiadanDate) {
        this.xiadanDate = xiadanDate;
    }

    public String getStartplace() {
        return startplace;
    }

    public void setStartplace(String startplace) {
        this.startplace = startplace;
    }

    public String getEndplace() {
        return endplace;
    }

    public void setEndplace(String endplace) {
        this.endplace = endplace;
    }

    public String getConsigner() {
        return consigner;
    }

    public void setConsigner(String consigner) {
        this.consigner = consigner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getQuhuo() {
        return quhuo;
    }

    public void setQuhuo(Date quhuo) {
        this.quhuo = quhuo;
    }

    public String getPaycount() {
        return paycount;
    }

    public void setPaycount(String paycount) {
        this.paycount = paycount;
    }

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public String getChaxunshu() {
        return chaxunshu;
    }

    public void setChaxunshu(String chaxunshu) {
        this.chaxunshu = chaxunshu;
    }

    public String getChaxunreal() {
        return chaxunreal;
    }

    public void setChaxunreal(String chaxunreal) {
        this.chaxunreal = chaxunreal;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoCount() {
        return cargoCount;
    }

    public void setCargoCount(String cargoCount) {
        this.cargoCount = cargoCount;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(String cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoBulk() {
        return cargoBulk;
    }

    public void setCargoBulk(String cargoBulk) {
        this.cargoBulk = cargoBulk;
    }

    public String getCargoZweight() {
        return cargoZweight;
    }

    public void setCargoZweight(String cargoZweight) {
        this.cargoZweight = cargoZweight;
    }

    public String getCargoZbulk() {
        return cargoZbulk;
    }

    public void setCargoZbulk(String cargoZbulk) {
        this.cargoZbulk = cargoZbulk;
    }

    public String getCargoZcount() {
        return cargoZcount;
    }

    public void setCargoZcount(String cargoZcount) {
        this.cargoZcount = cargoZcount;
    }

    public String getCargoImg() {
        return cargoImg;
    }

    public void setCargoImg(String cargoImg) {
        this.cargoImg = cargoImg;
    }

    public String getFahuoExplain() {
        return fahuoExplain;
    }

    public void setFahuoExplain(String fahuoExplain) {
        this.fahuoExplain = fahuoExplain;
    }

    public String getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(String cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public String getHaveyPrice() {
        return haveyPrice;
    }

    public void setHaveyPrice(String haveyPrice) {
        this.haveyPrice = haveyPrice;
    }

    public String getLightPrice() {
        return lightPrice;
    }

    public void setLightPrice(String lightPrice) {
        this.lightPrice = lightPrice;
    }

    public String getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(String basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Integer getTranstime() {
        return transtime;
    }

    public void setTranstime(Integer transtime) {
        this.transtime = transtime;
    }

    public String getTiGoods() {
        return tiGoods;
    }

    public void setTiGoods(String tiGoods) {
        this.tiGoods = tiGoods;
    }

    public String getSubmitstate() {
        return submitstate;
    }

    public void setSubmitstate(String submitstate) {
        this.submitstate = submitstate;
    }

    public String getShGoods() {
        return shGoods;
    }

    public void setShGoods(String shGoods) {
        this.shGoods = shGoods;
    }

    public String getZfPrice() {
        return zfPrice;
    }

    public void setZfPrice(String zfPrice) {
        this.zfPrice = zfPrice;
    }

    public String getShouhuo() {
        return shouhuo;
    }

    public void setShouhuo(String shouhuo) {
        this.shouhuo = shouhuo;
    }

    public String getShphone() {
        return shphone;
    }

    public void setShphone(String shphone) {
        this.shphone = shphone;
    }

    public String getShlxphone() {
        return shlxphone;
    }

    public void setShlxphone(String shlxphone) {
        this.shlxphone = shlxphone;
    }
}
