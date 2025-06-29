package com.hjc.todolist.service;

import com.hjc.todolist.entity.UserAuths;

import java.util.List;

public interface UserAuthsService {
    String addUserAuths(UserAuths userAuths);
    String updateUserAuths(UserAuths userAuths);
    String deleteUserAuths(List<Long> ids);
    List<UserAuths> getAllUserAuths();
    UserAuths getUserAuthsById(Long id);
    List<UserAuths> getUserAuthsByIds(List<Long> ids);
    List<UserAuths> getUserAuthsByPage(Integer page, Integer pageSize);
}
