package com.example.cruddemo.service;

import com.example.cruddemo.bean.User;
import com.example.cruddemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Integer login(User user){

        if(userMapper.login(user)== null)
            return 0;
        else
            return 1;

    }

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    public Integer insertUser(User user){
        return userMapper.insertUser(user);
    }
}
