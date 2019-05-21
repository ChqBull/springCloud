package com.jk.dao;

import com.jk.pojo.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findPhoeNumberByUserType(String phoneNumber);
}
