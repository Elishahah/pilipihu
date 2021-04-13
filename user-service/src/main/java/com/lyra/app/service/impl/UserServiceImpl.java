package com.lyra.app.service.impl;

import com.lyra.app.beans.User;
import com.lyra.app.mapper.UserMapper;
import com.lyra.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUser(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public void newUser(User user) {
        userMapper.newUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUserById(id);
    }
}
