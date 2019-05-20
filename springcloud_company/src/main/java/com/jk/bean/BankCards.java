package com.jk.bean;

import lombok.Data;

@Data
public class BankCards {
    private Integer bId;
    private String bankCardsNumber;
    private Integer bankCardsPassword;
    private Integer companyId;
    private Integer withdrawalPassword;
}
