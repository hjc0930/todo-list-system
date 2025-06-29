package com.hjc.todolist.common;

public enum UserAuthsIdentityType {
    EMAIL("email", "邮箱"),
    PHONE("phone", "手机"),
    WEICHAT("weichat", "微信");

    private final String code;
    private final String desc;

    UserAuthsIdentityType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
