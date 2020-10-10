package com.jyinfo.jy_service.service;

import com.jyinfo.jy_utils.result.ResponseVo;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    ResponseVo loginInfo(String userLoginInfo, HttpServletRequest request);

    void newUserRegister(String fName, String fPassword, HttpServletRequest request);
}
