package com.jyinfo.jy_service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jyinfo.jy_domain.Entity.mybatisEntity.LoginLogEntity;
import com.jyinfo.jy_domain.Entity.mybatisEntity.UserEntity;
import com.jyinfo.jy_domain.mapper.mybatisMapper.LoginLogEntityMapper;
import com.jyinfo.jy_domain.mapper.mybatisMapper.LoginMapper;
import com.jyinfo.jy_domain.mapper.mybatisMapper.UserMapper;
import com.jyinfo.jy_domain.mapper.mybatisMapper.UserEntityMapper;
import com.jyinfo.jy_security.shiro.JWTUtil;
import com.jyinfo.jy_service.service.LoginService;
import com.jyinfo.jy_utils.IPAddress.IPAddress;
import com.jyinfo.jy_utils.TipException.MyTipException;
import com.jyinfo.jy_utils.TipException.PasswordUnmatchedException;
import com.jyinfo.jy_utils.TipException.RegisterException;
import com.jyinfo.jy_utils.TipException.UserAlreadyExistException;
import com.jyinfo.jy_utils.result.ResponseVo;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private LoginMapper loginMapper;
    @Resource
    private UserEntityMapper userEntityMapper;
    @Resource
    private LoginLogEntityMapper loginLogEntityMapper;
    @Resource
    private UserMapper userMapper;


    @Override
    public ResponseVo loginInfo(String userLoginInfo,  HttpServletRequest request) {
        try{

            JSONObject mapTypes = JSON.parseObject(userLoginInfo);
            JSONObject parseResult=JSON.parseObject(mapTypes.getString("userLoginInfo"));
            String loginName=(String)parseResult.get("loginName");
            String loginPassword=(String)parseResult.get("loginPassword");
            //验证登录账户和密码
            if(!loginName.isEmpty() && !loginPassword.isEmpty() ){
                UserEntity userEntity=userMapper.UserNameExist(loginName);
                //验证用户名是否存在
                if(userMapper.UserNameExist(loginName)!=null){
                    String name=userEntity.getfUserName();
                    String password=userEntity.getfUserPassword();
                    if(loginName.equals(name)){
                        if(loginPassword.equals(password)){
                            HttpSession userInfo=request.getSession();
                            userInfo.setMaxInactiveInterval(24*60*60);
                            userInfo.setAttribute("fName",loginName);
                            userInfo.setAttribute("fPassword",loginPassword);

                            return new ResponseVo(200,"登录成功",JWTUtil.sign(name,password));
                        }
                        return new ResponseVo(-1,"用户名或密码不匹配");
                    }
                    return new ResponseVo(-1,"用户名或密码不匹配");
                }

                return new ResponseVo(-1,"用户名尚未注册");
            }

            return new ResponseVo(-1,"用户名或密码不能为空");
        }catch (RuntimeException e){
            throw new PasswordUnmatchedException();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseVo(200,"登录成功");
    }

    @Override
    public void newUserRegister(String fName, String fPassword, HttpServletRequest request) {

        //判断用户名是否存在
        if(userMapper.UserNameExist(fName)!=null) {
            throw new UserAlreadyExistException("用户账户已存在");
        }
        Date date = DateUtils.round(new Date(), Calendar.SECOND);
        UserEntity userEntity = new UserEntity();

        //保存用户自身信息
        String JWtToken= JWTUtil.sign(fName,fPassword);
        userEntity.setfUserPassword(fPassword);
        userEntity.setfCreateTime(date);
        userEntity.setfUpdateTime(date);
        userEntity.setfUserName(fName);//当注册教练和武馆时，默认1不可用(通过认证后可用)
        try {
            if(userEntityMapper.insert(userEntity)!=1){
                throw new RegisterException("注册失败");
            }
            LoginLogEntity loginLogEntity=new LoginLogEntity();
            loginLogEntity.setfUserId(userEntity.getfUserId());
            loginLogEntity.setfIpAddress(IPAddress.getIpAddress(request))  ;
            loginLogEntity.setfLoginTime(new Date());
            Integer i = loginLogEntityMapper.insert(loginLogEntity);
            if (i<1) {
                throw new MyTipException("登陆日志创建失败");
            }

        }catch (Exception e) {

            logger.error("----------用户登录账号：["+userEntity.getfUserName()+"]用户，注册时故障----------错误原因：["+e.getMessage()+"]----------发生故障时间："+new Date());
            if(e instanceof RuntimeException) {
                throw new MyTipException(e.getMessage());
            }
            e.printStackTrace();
        }

    }
}
