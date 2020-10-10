package com.jyinfo.jy_service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jyinfo.jy_domain.Entity.mybatisEntity.DevelopConsultEntity;
import com.jyinfo.jy_domain.mapper.mybatisMapper.DevelopConsultEntityMapper;
import com.jyinfo.jy_service.service.DevelopConsultService;
import com.jyinfo.jy_utils.TipException.SubmitDevelopNeedException;
import constantNumber.StatusNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class DevelopConsultServiceImpl implements DevelopConsultService {
    private static final Logger logger= LoggerFactory.getLogger(DevelopConsultServiceImpl.class);

    @Resource
    private DevelopConsultEntityMapper developConsultEntityMapper;

    @Override
    public void developConsult(String developNeeds) {
        try{
            JSONObject mapTypes = JSON.parseObject(developNeeds);

            JSONObject parseResult=JSON.parseObject(mapTypes.getString("developNeeds"));
            DevelopConsultEntity developConsultEntity=JSONObject.toJavaObject(parseResult, DevelopConsultEntity.class);
            //插入数据库
            if(developConsultEntityMapper.insert(developConsultEntity)!= StatusNumber.queryCount.queryResult()){
                throw new SubmitDevelopNeedException("提交开发需求异常");
            }
        }catch (RuntimeException e){
            logger.info(e.getMessage());
        }catch (Exception e){
            logger.error("提交开发需求出现未知异常");
        }
    }
}
