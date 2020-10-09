package com.example.cruddemo.config;


import com.example.cruddemo.bean.User;
import com.example.cruddemo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/emp/**").hasRole("emp")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler((req, res, exception) -> {
                    Object principal = exception.getPrincipal();
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter out = res.getWriter();
                    res.setStatus(200);
                    Map<String, Object> map = new HashMap<>();
                    System.out.println(principal);
                    map.put("userData", principal);
                    map.put("msg", "登陆成功！");
                    map.put("status", 200);
                    ObjectMapper om = new ObjectMapper();
                    out.write(om.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, res, exception) -> {
                    System.out.println(exception.getMessage());
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter out = res.getWriter();
                    res.setStatus(403);
                    Map<String, Object> map = new HashMap<>();
                    map.put("msg", exception.getMessage());
                    map.put("status", 403);
                    ObjectMapper om = new ObjectMapper();
                    out.write(om.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .and()
                .csrf().disable();



    }
}
