package top.smartsoftware.springbootcrud.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.springbootcrud.bean.Employee;
import top.smartsoftware.springbootcrud.mapper.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees(){
        return employeeMapper.getAllEmployees();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMapper.getEmployeeById(id);
    }

    public Integer addEmp(Employee emp){
        return employeeMapper.addEmp(emp);
    }

    public Integer delEmpById(Integer id) { return employeeMapper.delEmpById(id);}

    public Integer editEmpById(Integer id,Employee employee) { return employeeMapper.editEmpById(id,employee);}

}
