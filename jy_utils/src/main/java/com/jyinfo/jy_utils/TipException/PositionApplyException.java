package com.jyinfo.jy_utils.TipException;

/**
 * 职位申请异常
 */
public class PositionApplyException  extends  RuntimeException{
    public PositionApplyException(){super();}

    public PositionApplyException(String msg){
        super(msg);
    }
}
