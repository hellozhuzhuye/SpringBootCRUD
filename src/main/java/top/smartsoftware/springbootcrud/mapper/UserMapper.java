package top.smartsoftware.springbootcrud.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.smartsoftware.springbootcrud.bean.Role;
import top.smartsoftware.springbootcrud.bean.User;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Repository
public interface UserMapper {


    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);

    @Select("SELECT r.id,r.name,r.nameZh FROM user u,user_role ur,role r where u.id=ur.uid and r.id=ur.rid and u.id=#{id}")
    List<Role> getRolesById(Integer id);
}
