package com.hjc.todolist.service;

import com.hjc.todolist.entity.TodoItems;

import java.util.List;

public interface TodoItemService {
    String addTodoItem(TodoItems todoItems);
    String updateTodoItem(TodoItems todoItems);
    String deleteTodoItem(Long id);
    List<TodoItems> getAllTodoItem();
    TodoItems getTodoItemById(Long id);
    List<TodoItems> getTodoItemByIds(List<Long> ids);
    List<TodoItems> getTodoItemByPage(Integer page, Integer pageSize);
}
