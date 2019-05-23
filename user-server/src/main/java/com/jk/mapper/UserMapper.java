package com.jk.mapper;

import com.jk.bean.CompanyModel;
import com.jk.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findUserByPhone(String phoneNumber);

    void saveOneUser(UserBean userBean);

    void saveComUser(UserBean userBean);

    UserBean getUserByPasPhone(UserBean userBean);

    CompanyModel findCompanyByName(@Param("companyName") String companyName);

    CompanyModel comlogin(UserBean userBean);

    CompanyModel findCompanyByPhone(@Param("phoneNumber") String phoneNumber);
}
