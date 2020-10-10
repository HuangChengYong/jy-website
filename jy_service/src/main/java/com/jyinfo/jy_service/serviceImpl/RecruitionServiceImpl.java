package com.jyinfo.jy_service.serviceImpl;

import PropertyUtils.PropertyUtil;
import VideoProcessUtils.ThreadTransVideo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jyinfo.jy_domain.Entity.mybatisEntity.DevelopConsultEntity;
import com.jyinfo.jy_domain.Entity.mybatisEntity.PositionApplyEntity;
import com.jyinfo.jy_domain.mapper.mybatisMapper.PositionApplyEntityMapper;
import com.jyinfo.jy_service.service.RecruitionService;
import com.jyinfo.jy_utils.DateUtil.DateUtil;
import com.jyinfo.jy_utils.SceneCode.Scene;
import com.jyinfo.jy_utils.TipException.MediaFormatErrorException;
import com.jyinfo.jy_utils.TipException.PositionApplyException;
import com.jyinfo.jy_utils.UUIDGenerator.UUIDGenerator;
import com.jyinfo.jy_utils.result.ResponseVo;
import constantNumber.StatusNumber;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecruitionServiceImpl implements RecruitionService {

    private static final Logger logger= LoggerFactory.getLogger(RecruitionServiceImpl.class);

    @Resource
    private PositionApplyEntityMapper positionApplyEntityMapper;


    /**
     * @param cvinfo  职位申请表单信息
     */
    @Override
    public void PositionApply(String cvinfo) {
        try{
            JSONObject mapTypes = JSON.parseObject(cvinfo);

            JSONObject parseResult=JSON.parseObject(mapTypes.getString("cvinfo"));
            //字符串转对象
            PositionApplyEntity positionApplyEntity=JSONObject.toJavaObject(parseResult, PositionApplyEntity.class);
            //插入数据库
            if(positionApplyEntityMapper.insert(positionApplyEntity)!= StatusNumber.queryCount.queryResult()){
                throw new PositionApplyException("职位申请异常");
            }
        }catch (Exception e){
            logger.info("职位申请异常",new Exception(e.getMessage()));
        }

    }

    /**
     * 简历及附件上传接口
     * @param uploadFile 文件
     * @param scene 场景码
     * @return
     */
    @Override
    public Map<String, String> uploadFile(MultipartFile uploadFile, String scene) throws RuntimeException, IOException {

        //为了避免文件名重复，在文件名前加UUID
        String uuid = UUIDGenerator.generateShortUUID();
        String fileName = uploadFile.getOriginalFilename();//上传文件的原始名称
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        String allowSuffixs="avi,mpg,wmv,3gp,mov,mp4,asf,asx,flv,wmv9,rm,rmvb,pdf,doc,xls,ppt,docx,pptx,jpg,jpeg,png,txt";
        if(StringUtils.isBlank(suffix) || (allowSuffixs.indexOf(suffix.toLowerCase())==-1)){ //非法文件类型，返回null
            throw new MediaFormatErrorException();
        }
        String uuidFileName = uuid + "." + suffix; //上传文件的新名称
        //设置文件保存的本地路径
        String relativePath = "assets/videos/" + Scene.sceneCode.get(scene)+ "/" + DateUtil.DateToString(new Date(),DateUtil.DateStyle.YYYYMMDD) + "/";
        String savePath= PropertyUtil.getProperty("MEDIA_REPOSITORY_PATH") + relativePath;
        String saveFullFile = savePath + uuidFileName;
        String relativeFile=relativePath+uuidFileName;
        /**
         * 实际的文件到服务器的类
         */
        File saveFile = new File(savePath);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        FileOutputStream OutputStream = new FileOutputStream(saveFullFile);
        OutputStream.write(uploadFile.getBytes());
        OutputStream.flush();
        OutputStream.close();
        Map<String,String> fileMap = new HashMap<>();

        fileMap.put("relativeFile",relativeFile);
        fileMap.put("fullFile",saveFullFile);
        return fileMap;
    }

    /**
     * 软件下载
     * @param softWareCode 软件编号
     */
    @Override
    public ResponseVo downLoadSoftWare(int softWareCode, OutputStream os) {

        try {
            //通过softWareCode查找软件存放位置
            String path="";
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ResponseVo();
    }
}
