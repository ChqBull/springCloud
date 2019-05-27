package com.jk.dao;

import com.jk.pojo.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findPhoeNumberByUserType(String phoneNumber);

    UserBean findUserByPassword(@Param("u") UserBean user2);

    void updatePassword(UserBean user1);
}
