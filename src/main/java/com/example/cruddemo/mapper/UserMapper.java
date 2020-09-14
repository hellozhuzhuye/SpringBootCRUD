package com.example.cruddemo.mapper;

import com.example.cruddemo.bean.Role;
import com.example.cruddemo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select id from user where uname=#{uname} and pwd=#{pwd}")
    Integer login(User user);

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into user(uname,pwd) values(#{uname},#{pwd})")
    Integer insertUser(User user);

    @Select("select * from user where uname=#{uname}")
    User getUserByUsername(String username);

    @Select("select r.id,r.`name`,r.nameZh from role r,user_role ur where r.id =ur.id and ur.uid = #{id}")
    List<Role> getUserRolesByUid(Integer id);

}
