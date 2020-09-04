package com.example.cruddemo.mapper;

import com.example.cruddemo.bean.Employee;
import com.example.cruddemo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper{

    @Select("select * from Employee")
    List<Employee> getAllEmployee();


    @Select("select * from Employee where id = #{id}")
    Employee getEmployeeById(Integer id);



    @Insert("insert into Employee(gender,name,email) values(#{gender},#{name},#{email})")
    Integer addEmp(Employee emp);



}
