package com.hjc.todolist.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Users {
    private Long id;
    private String username;
    private String avatar;
    private Date createdTime;
    private Date updatedTime;
    private Date deletedTime;
    private Long createUser;
    private Long updateUser;
    private Long deleteUser;
}

