package com.study.springboot3.service;

import com.study.springboot3.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Integer id);

    User add(User user);

    User update(User user);

    boolean delete(Integer id);
}
