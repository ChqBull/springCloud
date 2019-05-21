package com.jk.dao;

import com.jk.pojo.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findUserByPhone(String phoneNumber);

    void saveOneUser(UserBean userBean);

    void saveComUser(UserBean userBean);

    UserBean getUserByPasPhone(UserBean userBean);
}
