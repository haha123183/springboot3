package com.study.springboot3.mapper;

import com.study.springboot3.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> getAll();
    User getById(@Param("id") Integer id);

    int insert(User user);

    int update(User user);

    int deleteById(@Param("id") Integer id);
}
