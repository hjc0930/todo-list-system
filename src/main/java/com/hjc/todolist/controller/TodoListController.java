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
        String result = todoListService.addTodoList(createTodoListDto);
        return Result.success(result);
    }

    @GetMapping("get-all")
    public Result<List<TodoListResDto>> getAllTodoLists() {
        List<TodoListResDto> todoLists = todoListService.getAllTodoList();
        return Result.success(todoLists);
    }

    @PutMapping("update/{id}")
    public Result<String> updateTodoList(@PathVariable Long id, @RequestBody @Valid CreateTodoListDto createTodoListDto) {
        String result = todoListService.updateTodoList(id, createTodoListDto);

        return Result.success(result);
    }
}
