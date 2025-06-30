package com.hjc.todolist.service;

import com.hjc.todolist.dto.CreateTodoListDto;
import com.hjc.todolist.dto.response.TodoListResDto;
import com.hjc.todolist.entity.TodoLists;

import java.util.List;

public interface TodoListService {
    String addTodoList(CreateTodoListDto createTodoListDto);
    String updateTodoList(TodoLists todoItems);
    String deleteTodoList(Long id);
    List<TodoListResDto> getAllTodoList();
    TodoLists getTodoListById(Long id);
    List<TodoLists> getTodoListByIds(List<Long> ids);
    List<TodoLists> getTodoListByPage(Integer page, Integer pageSize);
}
