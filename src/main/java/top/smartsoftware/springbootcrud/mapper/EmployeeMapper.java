package top.smartsoftware.springbootcrud.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.smartsoftware.springbootcrud.bean.Employee;

import java.util.List;

@Repository
public interface EmployeeMapper{

    @Select("select * from employee")
    List<Employee> getAllEmployees();


    @Select("select * from employee where id = #{id}")
    Employee getEmployeeById(Integer id);


    @Insert("insert into employee(gender,name,email) values(#{gender},#{name},#{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addEmp(Employee emp);

    @Delete("delete from employee where id = #{id}")
    Integer delEmpById(Integer id);

    @Update("update employee set gender=#{emp.gender},name=#{emp.name},email=#{emp.email} where id = #{emp.id}")
    Integer editEmpById(@Param("emp")Employee emp);


}
