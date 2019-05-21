package com.jk.service;

import com.jk.bean.UserBean;

public interface UserService {
    UserBean findPhoeNumberByUserType(String phoneNumber);
}
