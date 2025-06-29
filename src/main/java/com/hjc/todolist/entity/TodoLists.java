package com.hjc.todolist.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TodoLists {
    private Long id;
    private String name;
    private Integer status;
    private Date createdTime;
    private Date updatedTime;
    private Date deletedTime;
    private Long createUser;
    private Long updateUser;
    private Long deleteUser;
}

