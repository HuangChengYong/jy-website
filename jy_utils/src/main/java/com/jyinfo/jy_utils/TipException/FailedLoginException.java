package com.jyinfo.jy_utils.TipException;

/**
 * 登陆失败异常
 */
public class FailedLoginException  extends RuntimeException{

    public FailedLoginException(){super();}

    public FailedLoginException(String msg){
        super(msg);
    }

}
