package com.hjc.todolist.common;

public enum TodoListStatusEnum {
    PROCESS(0, "进行中"),
    COMPLETED(1, "已完成"),
    ARCHIVED(2, "已归档");

    private final int code;
    private final String desc;

    TodoListStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
