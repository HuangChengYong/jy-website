package com.jyinfo.jy_utils.TipException;

public class RegisterException extends  RuntimeException{
    public RegisterException(){super();}

    public RegisterException(String msg){
        super(msg);
    }
}
