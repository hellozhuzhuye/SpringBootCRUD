package com.example.cruddemo.mapper;

import com.example.cruddemo.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper{

    @Select("select * from employee")
    List<Employee> getAllEmployee();


    @Select("select * from employee where id = #{id}")
    Employee getEmployeeById(Integer id);


    @Insert("insert into employee(gender,name,email) values(#{gender},#{name},#{email})")
    Integer addEmp(Employee emp);

    @Delete("delete from employee where id = #{id}")
    Integer delEmpById(Integer id);


}
