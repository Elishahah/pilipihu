package com.lyra.app.mapper;

import com.lyra.app.beans.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> selectAll();
}
