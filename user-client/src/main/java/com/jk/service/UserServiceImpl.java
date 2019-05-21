package com.jk.service;
import com.jk.dao.UserMapper;
import com.jk.pojo.UserBean;
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
