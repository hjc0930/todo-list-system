package com.hjc.todolist.mapper;

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
    int insert(Users users);
    int update(Users users);
    int updateContain(Users users);
    int deleteById(@Param("id") Long id);
}

