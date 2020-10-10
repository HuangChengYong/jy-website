package com.jyinfo.jy_utils.TipException;

/**
 * 权限检查异常
 */
public class RightCheckException extends RuntimeException{
    public RightCheckException(){super();}

    public RightCheckException(String msg){
        super(msg);
    }
}
