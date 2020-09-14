package com.example.cruddemo.controller;

import com.example.cruddemo.bean.User;
import com.example.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id")Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String insertUser(User user){
        if(userService.insertUser(user)==1)
            return "regist success";
        else
            return "regist fail";
    }




}
