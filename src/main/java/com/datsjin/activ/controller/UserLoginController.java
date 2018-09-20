package com.datsjin.activ.controller;

import com.datsjin.activ.contants.BaseResponse;
import com.datsjin.activ.query.UserLoginListQuery;
import com.datsjin.activ.query.UserLoginQuery;
import com.datsjin.activ.service.UserLoginService;
import com.datsjin.activ.vo.UserLoginListVO;
import com.datsjin.activ.vo.UserLoginVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/userLogin")
public class UserLoginController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private UserLoginService userLoginService;

    @ApiOperation(value = "注册/维护个人信息", tags = "用户登陆管理")
    @RequestMapping(value = "/upsert", method = RequestMethod.POST)
    public BaseResponse<Integer> upsertUserLogin(@RequestBody UserLoginQuery userLoginQuery) {
        return new BaseResponse<>(this.userLoginService.upsertUserLogin(userLoginQuery));
    }

    @ApiOperation(value = "登陆", tags = "用户登陆管理")
    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public BaseResponse<UserLoginVO> getUserLoginInfo(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        return new BaseResponse<>(this.userLoginService.getUserLoginInfo(name,password));
    }
}
