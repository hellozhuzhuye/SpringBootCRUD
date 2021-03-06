package top.smartsoftware.springbootcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.smartsoftware.springbootcrud.bean.User;
import top.smartsoftware.springbootcrud.mapper.UserMapper;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        user.setRoles(userMapper.getRolesById(user.getId()));
        return user;

    }
}
