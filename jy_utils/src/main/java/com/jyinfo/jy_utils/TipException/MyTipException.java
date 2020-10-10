package com.jyinfo.jy_utils.TipException;

/**
 * 自定义异常，可以不定义枚举类
 */
public class MyTipException extends RuntimeException{
    public MyTipException(){super();}

    public MyTipException(String msg){
        super(msg);
    }
}
