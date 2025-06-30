package com.hjc.todolist.controller;

import com.hjc.todolist.dto.CreateTodoListDto;
import com.hjc.todolist.dto.response.TodoListResDto;
import com.hjc.todolist.entity.TodoLists;
import com.hjc.todolist.service.TodoListService;
import com.hjc.todolist.utils.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get-all")
    public Result<List<TodoListResDto>> getAllTodoLists() {
        List<TodoListResDto> todoLists = todoListService.getAllTodoList();
        return Result.success(todoLists);
    }
}
