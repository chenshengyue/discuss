package com.csy.discuss.web.aop;

import com.csy.discuss.core.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(com.csy.discuss.core.annotation.TestAspectTag)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        try{
            return joinPoint.proceed();
        } catch (Throwable e) {
            return Result.fail("系统异常");
        }
    }

}
