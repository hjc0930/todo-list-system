package com.hjc.todolist.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class TodoListResDto {
    private Long id;
    private String name;
    private String content;
    private Integer status;
    private Date createdTime;
    private Date updatedTime;
    private Long createUser;
    private Long updateUser;
}
