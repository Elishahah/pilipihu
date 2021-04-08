package com.lyra.app.mapper;

import com.lyra.app.beans.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
    User getUserById(int id);
    User getUserByName(String name);

    void newUser(User use);
}
