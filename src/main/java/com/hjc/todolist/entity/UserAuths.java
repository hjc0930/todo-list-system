package com.hjc.todolist.entity;

import lombok.Data;

@Data
public class UserAuths {
    private Long id;
    private Long userId;
    private String identityType;
    private String identifier;
    private String credential;
    private Integer verified;
}

