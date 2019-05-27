package com.jk.service;

import com.jk.dao.UserMapper;
import com.jk.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /*判断用户类型  1发货方 2物流公司*/
    @Override
    public UserBean findPhoeNumberByUserType(String phoneNumber) {
        return userMapper.findPhoeNumberByUserType(phoneNumber);
    }
    @Override
    public HashMap<String, Object> updatePas(String phoneNumber, String password, String password1) {
        HashMap<String, Object> hashMap = new HashMap<>();
        UserBean user2 = new UserBean();
        user2.setPhoneNumber(phoneNumber);
        user2.setPassword(password);
        UserBean user = userMapper.findUserByPassword(user2);
        if (user == null) {
            hashMap.put("code", 1);
            hashMap.put("msg", "密码错误");
            return hashMap;
        } else {

            UserBean user1 = new UserBean();
            user1.setPassword(password1);
            user1.setPhoneNumber(user.getPhoneNumber());
            userMapper.updatePassword(user1);
            hashMap.put("code", 0);
            hashMap.put("msg", "修改成功");
            return hashMap;
        }
    }
}