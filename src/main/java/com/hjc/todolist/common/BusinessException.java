package com.hjc.todolist.common;

public class BusinessException extends RuntimeException {
    private final int code;
    private final String message;

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.message = msg;
    }

    public BusinessException(BusinessCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
