package com.hjc.todolist.service;

import com.hjc.todolist.entity.Users;
import java.util.List;

public interface UserService {
    String login(String username, String password);
    String register(Users users);
    String updateUser(Users users);
    String deleteUser(List<Long> ids);
    List<Users> getAllUser();
    Users getUserById(Long id);
    List<Users> getUserByIds(List<Long> ids);
    List<Users> getUserByPage(Integer page, Integer pageSize);
}
