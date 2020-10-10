package com.jyinfo.jy_utils.TipException;

/**
 * 提交开发需求异常
 */
public class SubmitDevelopNeedException  extends RuntimeException{

    public SubmitDevelopNeedException(){super();}

    public SubmitDevelopNeedException(String msg){
        super(msg);
    }
}
