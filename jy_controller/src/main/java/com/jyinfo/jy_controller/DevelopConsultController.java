package com.jyinfo.jy_controller;


import com.jyinfo.jy_service.service.DevelopConsultService;
import com.jyinfo.jy_utils.result.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 开发咨询
 */
@RequestMapping("consult")
@RestController
@Api(tags = "开发需求咨询")
public class DevelopConsultController {

    @Resource
    private DevelopConsultService developConsultService;

    @RequestMapping(value = "developConsult",method={RequestMethod.POST})
    @ApiOperation(value="提交用户需求咨询",response=ResponseVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "developNeeds", value = "开发需求表单信息",dataType = "String"),
    })
    public ResponseVo developConsult(@RequestBody String developNeeds){

        developConsultService.developConsult(developNeeds);
        return new ResponseVo();
    }

    public static void main(String[] args) {
    }

}
