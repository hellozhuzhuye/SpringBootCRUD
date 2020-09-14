package com.example.cruddemo.controller;

import com.example.cruddemo.bean.User;
import com.example.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String login(User user) {
        System.out.println(user);
        if (userService.login(user)==1) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }
}
