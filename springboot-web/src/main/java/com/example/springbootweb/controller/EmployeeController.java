package com.example.springbootweb.controller;

import com.example.springbootweb.dao.EmployeeDao;
import com.example.springbootweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

/**
 * @author YZY
 * @date 2020/5/4 - 16:35
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/getAllEmployees")
    public String getAllEmployees(Model model){
        Collection<Employee> allEmloyees = employeeDao.findAllEmloyee();
        model.addAttribute("allEmloyees",allEmloyees);
        return "list";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
//        添加员工信息
        employeeDao.addEmployee(employee);
        return "redirect:/getAllEmployees";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
        return "redirect:/getAllEmployees";
    }


}
