package com.csy.discuss.core.common;

public class StateCodeConstants {

    public static String COMMON_FAIL_CODE = "-100";

    public static StateCode SUCCESS = new StateCode("200", "成功");

    public static StateCode SYSTEM_ERROR = new StateCode("-200", "系统异常");

    public static StateCode PARAM_ERROR = new StateCode("-201", "参数异常");

}
