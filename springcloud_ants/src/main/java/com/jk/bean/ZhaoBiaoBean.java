package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ZhaoBiaoBean {
      private Integer  zid;
      private String  zbtype;
      private String  title;
      private String hangye;
      private String startDate;
      private String endDate;
      private String zhuangtai;
       private String dianji;
       private String luruDate;
       private String zhaiyao;
}
