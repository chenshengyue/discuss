package com.csy.discuss.web.aop;

import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.exception.BizException;
import com.csy.discuss.core.exception.ParamException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class DubboDataAspect {

    @Pointcut("@annotation(com.csy.discuss.core.annotation.ServerCatch)")
    public void pointcut(){}

//    @Before("pointcut()")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("111");
//    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        try{
            return joinPoint.proceed();
        } catch (Throwable e) {

            //参数异常捕获
            if (e instanceof IllegalArgumentException) {

                return new Result("1", "参数校验异常");
            }
            //参数异常捕获
            if (e instanceof ParamException) {
                ParamException paramException = (ParamException) e;
                return new Result(paramException.getError().getErrorCode(), paramException.getError().getErrorMsg());
            }

            //自定义异常捕获
            if (e instanceof BizException) {
                BizException bizException = (BizException) e;
                return new Result(bizException.getError().getErrorCode(), bizException.getError().getErrorMsg());
            }

            System.out.println(e);

            return new Result("3", "系统异常");
        }
    }
}
