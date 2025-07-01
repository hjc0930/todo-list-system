package com.hjc.todolist.service.impl;

import com.hjc.todolist.common.BusinessCodeEnum;
import com.hjc.todolist.common.BusinessException;
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

    @Transactional
    @Override
    public String updateTodoList(Long id, CreateTodoListDto createTodoListDto) {
        TodoLists currentTodoList = todoListsMapper.selectById(id);
        if(Objects.isNull(currentTodoList)) {
            throw new BusinessException(BusinessCodeEnum.NOT_FOUND.getCode(), BusinessCodeEnum.NOT_FOUND.getMsg());
        }
        currentTodoList.setId(id);
        currentTodoList.setName(createTodoListDto.getName());
        currentTodoList.setStatus(createTodoListDto.getStatus());

        Long updatedTodoListId = todoListsMapper.update(currentTodoList);
        if (updatedTodoListId == null) {
            throw new BusinessException(BusinessCodeEnum.PARAM_ERROR.getCode(), BusinessCodeEnum.PARAM_ERROR.getMsg());
        }
        TodoItems todoItems = todoItemService.getTodoItemByListId(updatedTodoListId);
        if (Objects.isNull(todoItems)) {
            throw new BusinessException(BusinessCodeEnum.NOT_FOUND.getCode(), BusinessCodeEnum.NOT_FOUND.getMsg());
        }
        todoItems.setContent(createTodoListDto.getContent());
        todoItemService.addTodoItem(todoItems);

        return "OK";
    }

    @Transactional
    @Override
    public String deleteTodoList(Long id) {
        todoListsMapper.deleteById(id, 0L);
        return "OK";
    }

    @Override
    public List<TodoListResDto> getAllTodoList() {
        List<TodoLists> todoLists = todoListsMapper.selectAll();
        List<TodoItems> todoItemsList = todoItemService.getAllTodoItem();
        List<TodoListResDto> todoListResDtoList = new ArrayList<>();

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
            todoListResDtoList.add(todoListRes);
        });

        return todoListResDtoList;
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
