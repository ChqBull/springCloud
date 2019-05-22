package com.jk.mapper;

import com.jk.bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findUserByPhone(String phoneNumber);

    void saveOneUser(UserBean userBean);

    void saveComUser(UserBean userBean);

    UserBean getUserByPasPhone(UserBean userBean);
}
