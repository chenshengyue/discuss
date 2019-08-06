/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.csy.discuss.web.interceptor;

import com.csy.discuss.core.annotation.Login;
import com.csy.discuss.web.controller.WebUser;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/9/1 上午11:12 $
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler != null && handler instanceof HandlerMethod) {

            final HandlerMethod hm = (HandlerMethod) handler;

            Login userLogin = getAnnotation(hm.getMethod(), Login.class);

            if (userLogin != null) {

                //模拟从request中获取用户信息
                WebUser user = new WebUser();
                user.setUserName("1");
                user.setUserId(1L);

                MethodParameter[] parameters = hm.getMethodParameters();

                for (MethodParameter parameter : parameters) {
                    parameter.getParameterName();
                    Class<?> a = parameter.getDeclaringClass();
                    Class<?> b = parameter.getParameterType();
                }
            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private <T extends Annotation> T getAnnotation(Method method, Class<T> clazz) {
        T t = method.getAnnotation(clazz);
        if (t == null) {
            t = method.getDeclaringClass().getAnnotation(clazz);
        }
        return t;
    }

    private String getReqInfo(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        String param = "";
        if (req.getMethod().equals("GET")) {
            param = req.getQueryString() != null ? req.getQueryString() : "";
        } else if (req.getMethod().equals("POST")) {
            Map<String, String[]> reqParameterMap = req.getParameterMap();
            for (Map.Entry<String, String[]> entry : reqParameterMap.entrySet()) {
                param += entry.getKey() + "=" + (ArrayUtils.isNotEmpty(entry.getValue()) ? entry.getValue()[0] : "") + "&";
            }
            if (!"".equals(param)) {
                param = param.substring(0, param.length() - 1);
            }
        }
        sb.append(param);

        return sb.toString();
    }

}
