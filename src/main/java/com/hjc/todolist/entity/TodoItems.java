package com.hjc.todolist.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TodoItems {
    private Long id;
    private Long listId;
    private String content;
    private Date createdTime;
    private Date updatedTime;
    private Date deletedTime;
    private Long createUser;
    private Long updateUser;
    private Long deleteUser;
}

