package com.jyinfo.jy_controller;

import com.jyinfo.jy_utils.TipException.*;
import com.jyinfo.jy_utils.result.ResponseVo;
import constantNumber.StatusNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //自定义异常Map
    public static final  Map<Class<? extends RuntimeException>,Integer> exceptionMap=new HashMap<>();

    static {

        exceptionMap.put(PasswordUnmatchedException.class,1);
        exceptionMap.put(PositionApplyException.class,2);
        exceptionMap.put(RightCheckException.class,3);
        exceptionMap.put(FailedLoginException.class,4);
        exceptionMap.put(SubmitDevelopNeedException.class,5);
        exceptionMap.put(MediaFormatErrorException.class,6);

    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    public ResponseVo exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("发生未知异常！原因是:",e);
        return new ResponseVo(StatusNumber.errResponse.statusCode(),StatusNumber.errResponse.message());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    public ResponseVo NullPointerException(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return new ResponseVo(StatusNumber.NullPoint.statusCode(),StatusNumber.NullPoint.message());
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseVo RuntimeException(HttpServletRequest req, RuntimeException e){
        Integer exceptionIndex= exceptionMap.get(e.getClass());
        StatusNumber statusNumber;
        switch (exceptionIndex){
            case 1:
                 statusNumber=StatusNumber.PasswordUnmatched;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
            case 2:
                 statusNumber=StatusNumber.PositionApply;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
            case 3:
                 statusNumber=StatusNumber.RightCheck;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
            case 4:
                 statusNumber=StatusNumber.FailedLogin;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
            case 5:
                 statusNumber=StatusNumber.SubmitDevelopNeed;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
            case 6:
                statusNumber=StatusNumber.IllegalFileType;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
            default:

                logger.error("发生自定义业务异常！原因是：{}",e.getMessage());
                 statusNumber=StatusNumber.UnKnowEror;
                return new ResponseVo(statusNumber.statusCode(),statusNumber.message());
        }
    }

}
