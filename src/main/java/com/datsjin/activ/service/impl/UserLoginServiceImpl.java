package com.datsjin.activ.service.impl;

import com.datsjin.activ.exception.DatsjinException;
import com.datsjin.activ.mapper.UserMapper;
import com.datsjin.activ.po.User;
import com.datsjin.activ.po.UserExample;
import com.datsjin.activ.query.UserLoginQuery;
import com.datsjin.activ.service.UserLoginService;
import com.datsjin.activ.vo.UserLoginVO;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer upsertUserLogin(UserLoginQuery userLoginQuery) {
        User user=new User();
        BeanUtils.copyProperties(userLoginQuery,user);
        if(user.getId()==null){
            userMapper.insertSelective(user);
        }else{
            userMapper.updateByPrimaryKeySelective(user);
        }
        return user.getId();
    }

    @Override
    @SneakyThrows
    public UserLoginVO getUserLoginInfo(String name, String password) {
        UserLoginVO userLoginVO=new UserLoginVO();
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNameEqualTo(name)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()==0){
            throw new DatsjinException("登陆失败");
        }
        BeanUtils.copyProperties(users.get(0),userLoginVO);
        return userLoginVO;
    }
}
