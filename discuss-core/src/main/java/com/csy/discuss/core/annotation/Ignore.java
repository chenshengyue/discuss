package com.csy.discuss.core.annotation;

import java.lang.annotation.*;

/**
 * 不进行自定义参数校验
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ignore {
}
