package com.jk.mapper;

import com.jk.bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findPhoeNumberByUserType(String phoneNumber);
}
