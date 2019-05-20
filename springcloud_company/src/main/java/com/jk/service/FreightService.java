package com.jk.service;

import com.jk.bean.Freight;

import java.util.Map;

public interface FreightService {
    Map<String, Object> findFreightAll(int page, int limit, Freight freight);
}
