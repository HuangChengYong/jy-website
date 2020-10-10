package com.jyinfo.jy_utils.SceneCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传的场景码
 */
public class Scene {

    public  static final Map<String,String> sceneCode=new HashMap<>();

    static {
        //上传简历
        sceneCode.put("CV","CV");
        //上传附件
        sceneCode.put("attach","attach");
        //上传官网视频
        sceneCode.put("uploadJyinfoVideo","video");
        //上传甲悦TV短视频
        sceneCode.put("uploadJyTvVideo","video");
    }

}
