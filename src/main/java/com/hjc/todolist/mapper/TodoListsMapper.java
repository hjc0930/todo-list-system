package com.hjc.todolist.mapper;

import com.hjc.todolist.entity.TodoLists;
import com.hjc.todolist.utils.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoListsMapper {
    TodoLists selectById(Long id);
    List<TodoLists> selectAll();
    List<TodoLists> selectByIds(@Param("ids") List<Long> ids);
    List<TodoLists> selectByPage(PageUtil pageParams);

    int insert(TodoLists todoLists);
    int update(TodoLists todoLists);
    int updateContain(TodoLists todoItems);
    int deleteById(@Param("id") Long id, @Param("deletedUserId") Long deletedUserId);
}

