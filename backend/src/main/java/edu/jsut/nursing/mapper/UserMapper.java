package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();
    List<User> queryByStatus(int status);
    int updateByPrimaryKey(User record);
}