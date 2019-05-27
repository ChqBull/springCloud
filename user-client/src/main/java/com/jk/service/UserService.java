package com.jk.service;

import com.jk.pojo.UserBean;

import java.util.HashMap;

public interface UserService {
    UserBean findPhoeNumberByUserType(String phoneNumber);

    HashMap<String, Object> updatePas(String phoneNumber, String password, String password1);
}
