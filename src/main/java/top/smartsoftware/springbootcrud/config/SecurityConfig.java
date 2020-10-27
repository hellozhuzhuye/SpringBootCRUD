package top.smartsoftware.springbootcrud.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;
import top.smartsoftware.springbootcrud.service.UserService;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userService);
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("$2a$10$xAcjyGL.09bV7wJmRYm3e.QrNnlH5dP7TevGn98DUwjU.kv6yF.bu").roles("admin")
//                .and()
//                .withUser("user").password("$2a$10$xAcjyGL.09bV7wJmRYm3e.QrNnlH5dP7TevGn98DUwjU.kv6yF.bu").roles("user")
//                .and()
//                .withUser("emp").password("$2a$10$xAcjyGL.09bV7wJmRYm3e.QrNnlH5dP7TevGn98DUwjU.kv6yF.bu").roles("emp");
    }


    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_admin > ROLE_user \n ROLE_user > ROLE_emp";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
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
                .rememberMe()
                .and()
                //开启跨域
                .cors()
                .and()
                .csrf()
                .disable();
    }
}
