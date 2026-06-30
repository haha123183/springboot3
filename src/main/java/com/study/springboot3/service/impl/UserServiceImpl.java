package com.study.springboot3.service.impl;

import com.study.springboot3.entity.User;
import com.study.springboot3.mapper.UserMapper;
import com.study.springboot3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public User add(User user) {
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        if (user.getStatus() == null) {
            user.setStatus(1);
        }
        userMapper.insert(user);
        return user;
    }

    @Override
    public User update(User user) {
        user.setUpdated(LocalDateTime.now());
        userMapper.update(user);
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id) > 0;
    }
}
