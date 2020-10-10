package com.jyinfo.jy_controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jyinfo.jy_service.service.RecruitionService;
import com.jyinfo.jy_utils.TipException.MediaFormatErrorException;
import com.jyinfo.jy_utils.result.ResponseVo;
import constantNumber.StatusNumber;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 职位招聘
 */
@RequestMapping("recruition")
@RestController
@Api(tags = "职位招聘")
public class RecruitionController {
    private static final Logger logger= LoggerFactory.getLogger(RecruitionController.class);


    @Autowired
    private RecruitionService recruitionService;

    @RequestMapping(value = "positionApply",method={RequestMethod.POST})
    @ApiOperation(value="职位申请",response= ResponseVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cvinfo", value = "职位申请信息",dataType = "String"),
    })
    public ResponseVo positionApply(@RequestBody String cvinfo ){

        recruitionService.PositionApply(cvinfo);
        return new ResponseVo();
    }


    @RequestMapping(value = "/uploadFile",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value="文件上传统一接口",response=ResponseVo.class)
    public ResponseVo uploadFile(@RequestParam("senceCode") String senceCode,HttpServletRequest request) {

        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        List<MultipartFile> multipartFile = multipartRequest.getFiles("files");//file是form-data中二进制字段对应的name
        String  senceCodes = request.getParameter("senceCode");//file是form-data中二进制字段对应的name
        String msg="操作失败";
        try {
            List<Map<String,String>> retList = new ArrayList<>();
            Map<String, String> retMap = null;
            for(MultipartFile uploadFile:multipartFile) {
                System.out.println(uploadFile.getName());
                //单文件上传
                retMap =  recruitionService.uploadFile(uploadFile,senceCodes);//认证场景
                retList.add(retMap);
            }
            return new ResponseVo(0,retList);
        }catch (Exception e){
            if(e instanceof MediaFormatErrorException){
                msg=e.getMessage();
                return new ResponseVo(StatusNumber.uploadFailed.statusCode(),StatusNumber.uploadFailed.message());
            }
            logger.error(msg,e);
            return new ResponseVo(-1,e.getMessage());
        }
    }

    @RequestMapping(value = "downLoadSoftWare",method={RequestMethod.POST})
    @ApiOperation(value="软件下载",response= ResponseVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "softWareCode", value = "软件编号",dataType = "int"),
    })
    public ResponseVo downLoadSoftWare(@RequestParam("softWareCode") int softWareCode,@RequestParam("softWareName") String softWareName, HttpServletResponse response){

        try{
            //通过softWareCode获取软件名
            String path = "软件名称.xlsx";
            OutputStream os = response.getOutputStream();
            // 清空response
            response.reset();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            response.setHeader("Content-disposition","attachment; filename=" +
                    new String(softWareName.getBytes("utf-8"),"ISO-8859-1"));
            response.setContentType("application/msexcel");
            byte[] buffer = new byte[fis.available()];
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            ResponseVo responseVo=recruitionService.downLoadSoftWare(softWareCode,os);
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            return new ResponseVo();

        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseVo();
        }

    }
}
