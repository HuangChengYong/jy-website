package com.jyinfo.jy_service.service;

import com.jyinfo.jy_utils.result.ResponseVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public interface RecruitionService {

    /**
     * 职位申请
     * @param cvinfo  简历表单信息
     */
    void PositionApply(String cvinfo);

    /**
     * 文件上传
     * @param uploadFile 图片文件
     * @param scene 场景码
     * @return
     * @throws
     * @throws Exception
     */
    Map<String,String> uploadFile(MultipartFile uploadFile, String scene) throws IOException;

    /**
     * 软件下载
     * @param softWareCode 软件编号
     */
    ResponseVo downLoadSoftWare(int softWareCode, OutputStream os);
}
