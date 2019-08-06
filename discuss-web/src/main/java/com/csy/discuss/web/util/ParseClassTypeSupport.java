package com.csy.discuss.web.util;

import java.util.Arrays;
import java.util.List;

/**
 * 类型支持
 * 
 * @author pengdc
 * @version $Id: ClassTypeSupport.java, v 0.1 2016年4月25日 下午3:35:22 user Exp $
 */
public class ParseClassTypeSupport {

    /*基础数据类型以及封装类*/
    static String       javaBaseType[] = { "byte", "java.lang.Byte", "short", "java.lang.Short", "int", "java.lang.Integer",
            "long", "java.lang.Long", "double", "java.lang.Double", "float", "java.lang.Float",
            "java.lang.Boolean", "java.lang.String", "java.util.Date" };
    /*基础引用类型*/
    public static List<String> baseTypeList = Arrays.asList(javaBaseType);

    public static boolean isBaseType(Class<?> classType) {
        return baseTypeList.contains(classType.getName()) || classType.isEnum();
    }

    public static boolean isArray(Class<?> classType) {
        return classType.getName().startsWith("[");
    }

    public static boolean isCollection(Class<?> clazz) {
        return java.util.Collection.class.isAssignableFrom(clazz);
    }

    public static boolean isMap(Class<?> classType) {
        return java.util.Map.class.isAssignableFrom(classType);
    }

}
