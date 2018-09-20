package com.datsjin.activ.service;

import com.datsjin.activ.query.UserLoginQuery;
import com.datsjin.activ.vo.UserLoginVO;

public interface UserLoginService {
    Integer upsertUserLogin(UserLoginQuery userLoginQuery);

    UserLoginVO getUserLoginInfo(String name, String password);
}
