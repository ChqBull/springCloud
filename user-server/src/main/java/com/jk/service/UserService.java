package com.jk.service;

import com.jk.bean.CompanyModel;
import com.jk.bean.UserBean;

import java.util.HashMap;

public interface UserService {

    HashMap<String, Object>  phoneTest(String phoneNumber);

    HashMap<String, Object> findUserByPhone(String phoneNumber);

    HashMap<String,Object> saveUser(UserBean userBean,String phonecode);

    UserBean login(UserBean userBean);

    CompanyModel comlogin(UserBean userBean);

    HashMap<String, Object> phoneLogin(UserBean userBean, String phonecode);

}
