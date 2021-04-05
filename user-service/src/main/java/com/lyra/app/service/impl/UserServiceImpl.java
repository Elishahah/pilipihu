package com.lyra.app.service.impl;

import com.lyra.app.beans.User;
import com.lyra.app.mapper.UserMapper;
import com.lyra.app.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSession session;

    @Override
    public List<User> getAllUser() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.selectAll();
    }
}
