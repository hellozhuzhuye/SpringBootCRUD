package com.example.cruddemo.mapper;

import com.example.cruddemo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select id from User where uname=#{uname} and pwd=#{pwd}")
    Integer login(User user);

    @Select("select * from User")
    List<User> getAllUsers();

    @Select("select * from User where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into User(uname,pwd) values(#{uname},#{pwd})")
    Integer insertUser(User user);

}
