package top.smartsoftware.springbootcrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.springbootcrud.bean.Employee;
import top.smartsoftware.springbootcrud.service.EmployeeService;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/emps",method= RequestMethod.GET)
    public List<Employee> getEmployees(){
        List<Employee> employeeList= employeeService.getAllEmployees();
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

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String delEmpById(@PathVariable Integer id){
        if(employeeService.delEmpById(id)==1)
            return "del emp success";
        else
            return "del emp fail";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String editEmp(@PathVariable Integer id,Employee employee){
        if(employeeService.editEmpById(id,employee)==1)
            return "edit emp success";
        else
            return "edit emp fail";
    }


}
