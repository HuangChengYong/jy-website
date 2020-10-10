package com.jyinfo.jy_utils.TipException;

/**
 * 用户已存在
 */
public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(){super();}

    public UserAlreadyExistException(String msg){
        super(msg);
    }

}
