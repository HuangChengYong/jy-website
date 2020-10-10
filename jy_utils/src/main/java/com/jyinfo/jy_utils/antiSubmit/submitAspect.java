package com.jyinfo.jy_utils.antiSubmit;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 防重复提交切面类
 */
@Aspect
@Component
public class submitAspect {

//    @Resource
//    private RedisUtil redisUtil;
//
//    @Value("${user.session.key}")
//    private String userSessionKey;
//
//    @Pointcut(value = "@annotation(com.mypage.annotation.ArticleReSubmit)")
//    public void annotationPointCut() {
//
//    }
//
//    @Around("annotationPointCut()")
//    public Object NoReSubmit(ProceedingJoinPoint joinPoint) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        //获取request
//        HttpServletRequest request = attributes.getRequest();
//        HttpSession session = request.getSession();
//        //从session中获取登录的user对象，如果为null,则要求重新登录
//        Object sessionUser = session.getAttribute(userSessionKey);
//        if (sessionUser == null) {
//            return new Result<>().setMessage("页面超时，请重新登录");
//        }
//        User user = (User) sessionUser;
//        Integer userId = user.getId();
//        //获取接口的请求参数，如果时Article类型，则保存为Article对象，使用Article对象里的title属性
//        Object[] args = joinPoint.getArgs();
//        Article article = null;
//        for (Object object : args) {
//            if (object instanceof Article) {
//                article = (Article) object;
//            }
//        }
//        if (args == null) {
//            return new Result<>().setMessage("请求参数错误");
//        }
//
//        //组装redis key 从redis中获取对应的值
//        String key = userId + "_" + article.getTitle();
//        Object flag = redisUtil.getStr(key);
//
//        //如果redis中不存在对应的值，则执行原有的代码逻辑（插入文章操作）
//        if (flag == null) {
//            //redis设置key,value值为1
//            redisUtil.setStr(key, "1");
//            //设置有效期为5分钟
//            redisUtil.strSetExpireSeconds(key, 5*60L);
//            try {
//                return joinPoint.proceed();
//            } catch (Throwable throwable) {
//                redisUtil.delStr(key);
//                return new Result<>().setMessage("系统错误，请联系管理员！");
//            }
//        } else {
//            //如果redis中存在对应的值，则证明重复提交，返回对应的信息
//            log.info("{}:重复提交", key);
//            return new Result<>().setMessage("重复提交");
//        }
//    }
}
