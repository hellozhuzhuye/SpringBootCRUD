package com.example.cruddemo.service;

import com.example.cruddemo.bean.Employee;
import com.example.cruddemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee(){
        return employeeMapper.getAllEmployee();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMapper.getEmployeeById(id);
    }

    public Integer addEmp(Employee emp){
        return employeeMapper.addEmp(emp);
    }

}
