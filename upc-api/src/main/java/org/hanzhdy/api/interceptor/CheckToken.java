package org.hanzhdy.api.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * token拦截器的注解
 * Created by H.CAAHN on 2017/6/28.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckToken {
    /**
     * 返回是否需要校验token有效性, true为需要，false为不需要，默认为true
     * @return
     */
    boolean check() default true;
}
