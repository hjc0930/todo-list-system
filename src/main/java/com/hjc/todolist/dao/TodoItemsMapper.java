package com.hjc.todolist.dao;

import com.hjc.todolist.entity.TodoItems;
import com.hjc.todolist.utils.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface TodoItemsMapper {
    TodoItems selectById(Long id);
    List<TodoItems> selectAll();
    List<TodoItems> selectByIds(@Param("ids") List<Long> ids);
    List<TodoItems> selectByListIds(@Param("listIds") List<Long> listIds);
    List<TodoItems> selectByPage(PageUtil pageParams);

    Long insert(TodoItems todoItems);
    Long update(TodoItems todoItems);
    Long deleteById(@Param("id") Long id, @Param("deletedUserId") Long deletedUserId);
}

