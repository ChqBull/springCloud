package com.jk.service;

import com.jk.pojo.RegType;
import com.jk.pojo.UserBean;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    HashMap<String, Object>  phoneTest(String phoneNumber);

    HashMap<String, Object> findUserByPhone(String phoneNumber);

    List<RegType> findRegType();

    HashMap<String,Object> saveUser(UserBean userBean,String phonecode);

    UserBean login(UserBean userBean);

    HashMap<String, Object> phoneLogin(UserBean userBean, String phonecode);

    /*UserBean findPhoeNumberByUserType(String phoneNumber);*/
}
