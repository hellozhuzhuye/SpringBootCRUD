package com.example.cruddemo.mapper;

import com.example.cruddemo.bean.Role;
import com.example.cruddemo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserMapper {

    @Select("select id from user where username=#{username} and password=#{password}")
    Integer login(User user);

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    Integer insertUser(User user);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Select("select r.id,r.`name`,r.nameZh from role r,user_role ur where r.id =ur.id and ur.uid = #{id}")
    List<Role> getUserRolesByUid(Integer id);

}
