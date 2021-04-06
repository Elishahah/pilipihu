package com.lyra.app.service.impl;

import com.lyra.app.beans.User;
import com.lyra.app.mapper.UserMapper;
import com.lyra.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}
