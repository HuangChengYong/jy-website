package com.jyinfo.jy_utils.antiSubmit;

import java.lang.annotation.*;

/**
 * 防止接口重复提交
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface reSubmit {
}