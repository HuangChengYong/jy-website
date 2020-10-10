package com.jyinfo.jy_controller;

import com.jyinfo.jy_service.service.LoginService;

import com.jyinfo.jy_utils.result.ResponseVo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RequestMapping("login")
@RestController
@Api(tags = "用户登陆接口")
public class LoginController {
    private static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "loginInfo",method = {RequestMethod.POST})
    @ApiOperation(value="获取用户信息",notes="获取登录用户信息",response = ResponseVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userLoginInfo", value = "登录账户信息",dataType = "string",required = true)
    })
    public ResponseVo loginInfo(@RequestBody String userLoginInfo, HttpServletRequest request){



        return loginService.loginInfo(userLoginInfo,request);
    }

    /**
     * 用户注册（新）
     * @param fName              手机短信验证码
     * @param fPassword         密码
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "用户注册",notes = "用户注册", response = ResponseVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fName", value = "用户名", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "fPassword", value = "登录密码", paramType = "query", dataType = "string", required = true)
    })
    public ResponseVo register(String fName,String fPassword, HttpServletRequest request){
        //验证用户名是否存在

            loginService.newUserRegister(fName,fPassword,request);
            return new ResponseVo(200,"注册成功");//注册

    }


}
