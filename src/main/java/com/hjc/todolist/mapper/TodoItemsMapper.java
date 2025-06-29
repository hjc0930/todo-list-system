package com.hjc.todolist.mapper;

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
    List<TodoItems> selectByPage(PageUtil pageParams);

    int insert(TodoItems todoItems);
    int update(TodoItems todoItems);
    int updateContain(TodoItems todoItems);
    int deleteById(@Param("id") Long id, @Param("deletedUserId") Long deletedUserId);
}

