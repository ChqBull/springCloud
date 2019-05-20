package com.jk.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//财务表
@Data
public class FinanciaModel {
    private Integer fId;//主键
    private String tradingNumber;//交易号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date tradingDate;//交易日期
    private Integer transactionAmount;//交易金额
    private String transactionType;//交易类型 (1 支出 2 收入)
    private Integer budgetType;//收支类型 (1 支出 2 收入)
    private String note;//备注
    private Integer companyId;
}
