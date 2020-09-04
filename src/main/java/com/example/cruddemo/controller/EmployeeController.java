package com.example.cruddemo.controller;

import com.example.cruddemo.bean.Employee;
import com.example.cruddemo.bean.User;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public List<Employee> getEmployees(){
        List<Employee> employeeList= employeeService.getAllEmployee();
        return employeeList;
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addEmp(Employee emp){
        if(employeeService.addEmp(emp)==1)
            return "add emp success";
        else
            return "add emp fail";
    }


}
