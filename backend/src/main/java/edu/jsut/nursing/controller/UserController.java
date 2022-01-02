package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.UserMapper;
import edu.jsut.nursing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserController
 * @Author Lnino
 * @Date 2021/12/30 11:03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("selAll")
    public List<User> selAll(){
        return userMapper.selectAll();
    }

    @RequestMapping("selbystatus/{status}")
    public List<User> queryBystatus(@PathVariable int status){
        return userMapper.queryByStatus(status);
    }

    @RequestMapping("sel/{id}")
    public User sel(@PathVariable Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("del/{id}")
    public String delete(@PathVariable Integer id){
        userMapper.deleteByPrimaryKey(id);
        return "success";
    }

    @RequestMapping("update")
    public String update(@RequestBody User user){
        userMapper.updateByPrimaryKey(user);
        return "success";
    }


    @RequestMapping("Add")
    public String add(@RequestBody User user){
        userMapper.insert(user);
        return "success";
    }


}
