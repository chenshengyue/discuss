package com.csy.discuss.core.common;

import com.csy.discuss.core.exception.BizError;

public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public Result() {

    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(StateCode stateCode) {
        this.code = stateCode.getCode();
        this.msg = stateCode.getMsg();
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(StateCode stateCode, T data) {
        this.code = stateCode.getCode();
        this.msg = stateCode.getMsg();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result success() {
        return new Result(StateCodeConstants.SUCCESS);
    }

    public static Result success(Object data) {
        return new Result(StateCodeConstants.SUCCESS, data);
    }

    public static Result fail(StateCode stateCode) {
        return new Result(stateCode);
    }

    public static Result fail(String code, String msg) {
        return new Result(code, msg);
    }

    public static Result fail(String msg) {
        return new Result(StateCodeConstants.COMMON_FAIL_CODE, msg);
    }

    public static Result fail(BizError bizError) {
        return new Result(bizError.getErrorCode(), bizError.getErrorMsg());
    }
}
