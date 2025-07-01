package com.hjc.todolist.service.impl;

import com.hjc.todolist.common.BusinessCodeEnum;
import com.hjc.todolist.common.BusinessException;
import com.hjc.todolist.common.ResultMessageConstant;
import com.hjc.todolist.entity.TodoItems;
import com.hjc.todolist.dao.TodoItemsMapper;
import com.hjc.todolist.service.TodoItemService;
import com.hjc.todolist.utils.PageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    @Resource
    private TodoItemsMapper todoItemsMapper;

    @Override
    public String addTodoItem(TodoItems todoItems) {
        todoItemsMapper.insert(todoItems);
        return ResultMessageConstant.ADD_TODO_ITEM_SUCCESS;
    }

    @Override
    public String updateTodoItem(TodoItems todoItems) {
        todoItemsMapper.update(todoItems);
        return ResultMessageConstant.UPDATE_TODO_ITEM_SUCCESS;
    }

    @Override
    public String deleteTodoItem(Long id) {
        // TODO: Intergration with UserService to check if the user has permission to delete this item
        todoItemsMapper.deleteById(id, null);
        return ResultMessageConstant.DELETE_TODO_ITEM_SUCCESS;
    }

    @Override
    public List<TodoItems> getAllTodoItem() {
        return  todoItemsMapper.selectAll();
    }

    @Override
    public TodoItems getTodoItemById(Long id) {
        return todoItemsMapper.selectById(id);
    }

    @Override
    public List<TodoItems> getTodoItemByIds(List<Long> ids) {
        return todoItemsMapper.selectByIds(ids);
    }

    @Override
    public List<TodoItems> getTodoItemByPage(Integer page, Integer pageSize) {
        if(Objects.isNull(page) || Objects.isNull(pageSize)) {
            throw new BusinessException(BusinessCodeEnum.PARAM_ERROR);
        }
        PageUtil pageParams = new PageUtil(page, pageSize);

        return todoItemsMapper.selectByPage(pageParams);
    }

    @Override
    public List<TodoItems> getTodoItemByListIds(List<Long> listIds) {
        return todoItemsMapper.selectByListIds(listIds);
    }

    @Override
    public TodoItems getTodoItemByListId(Long listId) {
        return todoItemsMapper.selectByListId(listId);
    }
}
