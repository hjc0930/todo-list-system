package com.hjc.todolist.dao;

import com.hjc.todolist.entity.UserAuths;
import com.hjc.todolist.utils.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAuthsMapper {
    UserAuths selectById(Long id);
    List<UserAuths> selectAll();
    List<UserAuths> selectByIds(@Param("ids") List<Long> ids);
    List<UserAuths> selectByPage(PageUtil pageParams);
    List<UserAuths> selectByUserIds(@Param("userIds") List<Long> userIds);
    Long insert(UserAuths userAuths);
    Long update(UserAuths userAuths);
    Long deleteById(@Param("id") Long id, @Param("deletedUserId") Long deletedUserId);
}

