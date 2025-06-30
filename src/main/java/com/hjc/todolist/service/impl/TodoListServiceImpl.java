package com.hjc.todolist.service.impl;

import com.hjc.todolist.dto.CreateTodoListDto;
import com.hjc.todolist.dto.response.TodoListResDto;
import com.hjc.todolist.entity.TodoItems;
import com.hjc.todolist.entity.TodoLists;
import com.hjc.todolist.dao.TodoListsMapper;
import com.hjc.todolist.service.TodoItemService;
import com.hjc.todolist.service.TodoListService;
import com.hjc.todolist.utils.PageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoListServiceImpl implements TodoListService {

    @Resource
    private TodoListsMapper todoListsMapper;
    @Resource
    private TodoItemService todoItemService;

    @Transactional
    @Override
    public String addTodoList(CreateTodoListDto createTodoListDto) {
        TodoLists todoLists = new TodoLists();
        todoLists.setName(createTodoListDto.getName());
        todoLists.setStatus(createTodoListDto.getStatus());
        todoListsMapper.insert(todoLists);
        TodoItems todoItems = new TodoItems();
        todoItems.setListId(todoLists.getId());
        todoItems.setContent(createTodoListDto.getContent());
        todoItemService.addTodoItem(todoItems);
        return "Ok";
    }

    @Override
    public String updateTodoList(TodoLists todoItems) {
        todoListsMapper.update(todoItems);
        return "OK";
    }

    @Override
    public String deleteTodoList(Long id) {
        todoListsMapper.deleteById(id, 0L);
        return "OK";
    }

    @Override
    public List<TodoListResDto> getAllTodoList() {
        List<TodoLists> todoLists = todoListsMapper.selectAll();
        List<TodoItems> todoItemsList = todoItemService.getAllTodoItem();
        List<TodoListResDto> todoListResDtos = new ArrayList<>();

        todoLists.stream()
                .filter(item -> Objects.isNull(item.getDeleteUser()))
                .forEach(item -> {
            TodoListResDto todoListRes = new TodoListResDto();
            todoListRes.setId(item.getId());
            todoListRes.setName(item.getName());
            todoListRes.setStatus(item.getStatus());
            todoListRes.setCreatedTime(item.getCreatedTime());
            todoListRes.setUpdatedTime(item.getUpdatedTime());
            todoItemsList.stream()
                    .filter(todoItem -> todoItem.getListId().equals(item.getId()))
                    .map(TodoItems::getContent)
                    .forEach(todoListRes::setContent);
            todoListResDtos.add(todoListRes);
        });

        return todoListResDtos;
    }

    @Override
    public TodoLists getTodoListById(Long id) {
        return todoListsMapper.selectById(id);
    }

    @Override
    public List<TodoLists> getTodoListByIds(List<Long> ids) {
        return todoListsMapper.selectByIds(ids);
    }

    @Override
    public List<TodoLists> getTodoListByPage(Integer page, Integer pageSize) {
        PageUtil pageUtil = new PageUtil(page, pageSize);
        return todoListsMapper.selectByPage(pageUtil);
    }
}
