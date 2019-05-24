package com.jk.service;

import com.jk.bean.*;

import java.util.HashMap;
import java.util.List;

public interface FrontdeskService {

    List<AreaData> serviceArea(Integer statrsquId);

    List<Wuliuxianlu> companyList(Integer statrsquId, Integer endquId);
}
