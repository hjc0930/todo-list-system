package com.hjc.todolist.controller;

import com.hjc.todolist.entity.Users;
import com.hjc.todolist.mapper.UsersMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Resource
    private UsersMapper usersMapper;

    @GetMapping("/all")
    public List<Users> selectUserAll() {
        return usersMapper.selectAll();
    }
}
