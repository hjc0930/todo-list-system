package com.hjc.todolist.service;

import com.hjc.todolist.entity.TodoLists;

import java.util.List;

public interface TodoListService {
    String addTodoList(TodoLists todoItems);
    String updateTodoList(TodoLists todoItems);
    String deleteTodoList(List<Long> ids);
    List<TodoLists> getAllTodoList();
    TodoLists getTodoListById(Long id);
    List<TodoLists> getTodoListByIds(List<Long> ids);
    List<TodoLists> getTodoListByPage(Integer page, Integer pageSize);
}
