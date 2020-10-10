package top.smartsoftware.springbootcrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.springbootcrud.bean.Employee;
import top.smartsoftware.springbootcrud.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/emps",method= RequestMethod.GET)
    public List<Employee> getEmployees(){
        List<Employee> employeeList= employeeService.getAllEmployees();
        if (employeeList != null) {
            return employeeList;
        }
        return null;
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Map<String,Object> getEmployeeById(@PathVariable Integer id){

        Employee employee=employeeService.getEmployeeById(id);
        Map<String,Object> map=new HashMap<>();

        if (employee!=null)
        {
            map.put("msg","查询成功");
            map.put("empData",employee);
            return map;
        }

        map.put("msg","查询的用户不存在！");
        return map;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> delEmpById(@PathVariable Integer id){
        Employee employee=employeeService.getEmployeeById(id);
        Map<String,Object> map=new HashMap<>();
        if(employeeService.delEmpById(id)!=0)
        {
            map.put("msg","删除员工成功");
            map.put("delEmpData",employee);
            return map;
        }
        map.put("msg","删除员工失败，员工信息不存在");
        return map;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Map<String,Object> editEmp(@PathVariable Integer id,Employee afterEditEmp){

        Employee beforeEditEmp = employeeService.getEmployeeById(id);

        Map<String,Object> map=new HashMap<>();
        try {
            if(employeeService.editEmpById(afterEditEmp)!=0)
            {
                map.put("msg","修改员工成功");
                map.put("beforeEditEmp",beforeEditEmp);
                map.put("afterEditEmp",employeeService.getEmployeeById(id));
                return map;
            }
            else{
                map.put("msg","修改员工失败，员工信息不存在");
                return map;
            }
        }catch (Exception e){
            map.put("msg","修改员工失败，员工信息不存在或姓名已存在！");
            return map;
        }


    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> addEmp(Employee emp){
        Map<String,Object> map=new HashMap<>();
        try {
            if(employeeService.addEmp(emp)!=0)
            {
                map.put("msg","新增用户成功");
                map.put("addEmpData",employeeService.getEmployeeById(emp.getId()));
                return map;
            }
            else{
                map.put("msg","新增用户失败，用户名已存在！");
                return map;
            }
        }catch (Exception e){
            map.put("msg","新增用户失败，用户名已存在！");
//            map.put("exception",e.getMessage());
            return map;
        }


    }

}
