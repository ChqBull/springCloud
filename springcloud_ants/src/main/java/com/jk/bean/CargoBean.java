package com.jk.bean;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;

@Data
public class CargoBean implements Serializable {

    private Integer id;//主键id
    private String test;//货物id

}
