package com.hjc.todolist.common;

public enum BusinessCodeEnum {
    SUCCESS(20000, "成功"),
    NOT_FOUND(40004, "未找到"),
    PARAM_ERROR(40000, "参数错误"),
    SYSTEM_ERROR(50000, "系统异常");

    private final int code;
    private final String msg;

    BusinessCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
