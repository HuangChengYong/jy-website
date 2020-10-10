package com.jyinfo.jy_utils.GsonUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jyinfo.jy_utils.result.ResponseVo;

public class toJson {

    /**
     * 将object对象转成json格式字符串
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

   /* *//**
     * 将json格式字符串 转成 object对象
     *//*
    public static Class toObject(String jsonString) {
        //User user = gson.fromJson(json, User.class);
        Gson gson=new Gson();
        return ()gson.fromJson(jsonString, objectClass);
    }*/

    public static void main(String[] args) {
        ResponseVo result=new ResponseVo();
        System.out.println(toJson.toJson(result));
    }
}
