package com.hjc.todolist.utils;

import lombok.Data;

@Data
public class Result <T>{
    private int code;    // 业务状态码（非HTTP状态码）
    private String msg;  // 提示信息
    private T data;      // 业务数据

    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static Result<Void> error() {
        Result<Void> result = new Result<>();
        result.setCode(500);
        result.setMsg("服务器错误");
        return result;
    }

    public static <T> Result<T> error(T data) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg("服务器错误");
        result.setData(data);
        return result;
    }

    public static Result<Void> error(int code, String msg) {
        Result<Void> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
