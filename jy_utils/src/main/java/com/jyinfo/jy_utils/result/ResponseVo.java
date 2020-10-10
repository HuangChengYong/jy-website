package com.jyinfo.jy_utils.result;


import com.jyinfo.jy_utils.GsonUtils.toJson;
import constantNumber.StatusNumber;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 */
@Data
public class ResponseVo implements Serializable {
    @ApiModelProperty(value="返回值状态码",name="状态码",required = true)
    private int code;
    @ApiModelProperty(value="返回值消息",name="消息提示",required = true)
    private String message;
    @ApiModelProperty(value="返回值数据",name="前端数据",required = true)
    private  Object  data;


    public ResponseVo(){
        StatusNumber statusNumber=StatusNumber.SuccessStatus;
        this.code= statusNumber.statusCode();
        this.message=statusNumber.message();
    }

    public ResponseVo(int code,String message){
        this.code= code;
        this.message=message;
    }

    public ResponseVo(int statusNumber,Object data){
        this.code= statusNumber;
        this.data=data;
    }

    public ResponseVo(int statusNumber,String message,Object data){
        this.code= statusNumber;
        this.message=message;
        this.data=data;
    }

    public ResponseVo success(int statusNumber,String message,Object data){



        return new ResponseVo(statusNumber,message,data);
    }

    @Override
    public String toString() {
        return toJson.toJson(this);
    }
}
