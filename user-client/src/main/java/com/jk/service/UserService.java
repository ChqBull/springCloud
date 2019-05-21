package com.jk.service;

import com.jk.pojo.UserBean;

public interface UserService {
    UserBean findPhoeNumberByUserType(String phoneNumber);
}
