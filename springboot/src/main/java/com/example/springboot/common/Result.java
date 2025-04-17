package com.example.springboot.common;

import jdk.internal.dynalink.beans.StaticClass;
import lombok.Data;

@Data
public class Result {
    private static final String SUCCESS_COOE = "200";
    private static final String ERROR_CODE = "-1";
    private String code;
    private Object data;
    private String msg;

    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS_COOE);
        return result;
    }
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_COOE);
        result.setData(data);
        return result;
    }
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setData(null);//这行可能没有
        result.setMsg(msg);
        return result;
    }
    public static Result error(String code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setData(null);//这行可能没有
        result.setMsg(msg);
        return result;
    }
}

