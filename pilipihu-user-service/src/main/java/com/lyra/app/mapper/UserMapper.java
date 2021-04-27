package com.lyra.app.mapper;

import com.lyra.app.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
    User getUserByName(String name);

    void newUser(@Param("user") User user);
    void deleteUserById(int id);
}
