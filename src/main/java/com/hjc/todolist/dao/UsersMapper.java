package com.hjc.todolist.dao;

import com.hjc.todolist.entity.Users;
import com.hjc.todolist.utils.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {
    Users selectById(Long id);
    List<Users> selectAll();
    List<Users> selectByIds(@Param("ids") List<Long> ids);
    List<Users> selectByPage(PageUtil pageParams);
    Long insert(Users users);
    Long update(Users users);
    Long deleteById(@Param("id") Long id);
}

