package com.hjc.todolist.controller;

import com.hjc.todolist.dto.CreateTodoListDto;
import com.hjc.todolist.service.TodoListService;
import com.hjc.todolist.utils.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo-list")
public class TodoListController {
    @Resource
    private TodoListService todoListService;

    @PostMapping("create")
    public Result<String> createTodoList(@RequestBody @Valid CreateTodoListDto createTodoListDto) {
        String resul = todoListService.addTodoList(createTodoListDto);
        return Result.success(resul);
    }
}
