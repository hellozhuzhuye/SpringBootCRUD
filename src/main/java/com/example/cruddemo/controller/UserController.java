package com.example.cruddemo.controller;

import com.example.cruddemo.bean.User;
import com.example.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user) {
        System.out.println(user);
        if (userService.login(user)==1) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }


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
