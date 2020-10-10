package com.jyinfo.jy_utils.TipException;

/**
 * 密码不匹配异常
 */
public class PasswordUnmatchedException extends RuntimeException {

    public PasswordUnmatchedException(){super();}

    public PasswordUnmatchedException(String msg){
        super(msg);
    }
}
