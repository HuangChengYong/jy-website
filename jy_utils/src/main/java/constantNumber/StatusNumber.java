package constantNumber;

import com.jyinfo.jy_utils.TipException.PasswordUnmatchedException;
import com.jyinfo.jy_utils.TipException.PositionApplyException;
import com.jyinfo.jy_utils.result.ResponseVo;

/**
 * 常用数值的状态描述
 */
public enum StatusNumber {

    //有一条查询结果
    queryCount(1),

    //状态完成
    SuccessStatus(0,"已完成"),

    //状态失败
    failedStatus(-1,"未完成"),

    //状态进行中
    UnderStatus(9,"进行中"),

    UNAUTHORIZED(401),//未认证（签名错误）

    messageTips(200,"请求完成"),

    errResult(404,"请求页面未发现"),

    errResponse(500,"服务器发生错误"),

    PositionApply(1000,"职位申请异常"),

    Unauthorized(1001,"未认证异常"),

    RightCheck(1005,"权限验证异常"),

    FailedLogin(1010,"登陆失败异常"),

    PasswordUnmatched(1015,"密码不匹配"),

    SubmitDevelopNeed(1020,"提交开发需求异常"),

    IllegalFileType(1025,"非法类型文件"),

    NullPoint(1023,"空指针异常"),

    UnKnowEror(1028,"服务器未知异常"),

    uploadFailed(1033,"文件上传失败");

    //查询结果的条数
    private int queryResult;
    //状态消息
    private String message;
    //状态码
    private int statusCode;

    StatusNumber(int queryResult){
        this.queryResult=queryResult;
    }

     StatusNumber(int statusCode,String message){
        this.statusCode=statusCode;
        this.message=message;
    }

    public static StatusNumber failedMesg(int statusCode,String message){
         return failedMesg(statusCode, message);
    }

    public int queryResult(){return  queryResult;}

    public int statusCode(){return  statusCode;}

    public String message(){return message;}

    public static void main(String[] args) {

        System.out.println(StatusNumber.SuccessStatus.statusCode);

        System.out.println(StatusNumber.queryCount.queryResult);

        System.out.println(new ResponseVo());

    }

}
