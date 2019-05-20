package com.jk.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LayUiUtil {
        private int code=0;
        private String msg;
        private Long count; //总条数
        private List data = new ArrayList(); //装前台当前页的数据

}
