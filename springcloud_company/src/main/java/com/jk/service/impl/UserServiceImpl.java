package com.jk.service.impl;

import com.jk.bean.UserBean;
import com.jk.mapper.UserMapper;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserBean findPhoeNumberByUserType(String phoneNumber) {
        return userMapper.findPhoeNumberByUserType(phoneNumber);
    }
}
