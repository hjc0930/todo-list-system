package com.hjc.todolist.service.impl;

import com.hjc.todolist.dto.CreateTodoListDto;
import com.hjc.todolist.entity.TodoItems;
import com.hjc.todolist.entity.TodoLists;
import com.hjc.todolist.dao.TodoListsMapper;
import com.hjc.todolist.service.TodoItemService;
import com.hjc.todolist.service.TodoListService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    @Resource
    private TodoListsMapper todoListsMapper;
    @Resource
    private TodoItemService todoItemService;

    @Override
    public String addTodoList(CreateTodoListDto createTodoListDto) {
        TodoLists todoLists = new TodoLists();
        todoLists.setName(createTodoListDto.getName());
        todoLists.setStatus(createTodoListDto.getStatus());
        int todoListId = todoListsMapper.insert(todoLists);

        List<TodoItems> todoItemsList = todoItemService.getAllTodoItem();

        return "";
    }

    @Override
    public String updateTodoList(TodoLists todoItems) {
        return "";
    }

    @Override
    public String deleteTodoList(List<Long> ids) {
        return "";
    }

    @Override
    public List<TodoLists> getAllTodoList() {
        return List.of();
    }

    @Override
    public TodoLists getTodoListById(Long id) {
        return null;
    }

    @Override
    public List<TodoLists> getTodoListByIds(List<Long> ids) {
        return List.of();
    }

    @Override
    public List<TodoLists> getTodoListByPage(Integer page, Integer pageSize) {
        return List.of();
    }
}
