package com.example.springbootweb.controller;

import com.example.springbootweb.dao.DepartmentDao;
import com.example.springbootweb.dao.EmployeeDao;
import com.example.springbootweb.pojo.Department;
import com.example.springbootweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author YZY
 * @date 2020/4/30 - 10:32
 */
@Controller
public class Contreoller {

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    EmployeeDao employeeDao;


//   登录
    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {
        if (username.length() != 0 && "1".equals(password)) {
            session.setAttribute("loginname",username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("message","登录失败");
            return "index";
        }
    }
//   注销
    @RequestMapping("/signOut")
    public String signout(HttpSession session){
        session.removeAttribute("loginname");
        return "redirect:/index.html";
    }

//  跳转添加页面
    @RequestMapping("/toaddE")
    public String addE(Model model){
        Collection<Department> allDepartment = departmentDao.findAllDepartment();
        model.addAttribute("allDepartment",allDepartment);
        return "addE";
    }

//  跳转修改页面
    @RequestMapping("/toupdateE")
    public String toupdateE(Integer id,Model model){
        Employee emloyeeById = employeeDao.findEmloyeeById(id);
        Collection<Department> allDepartment = departmentDao.findAllDepartment();
        model.addAttribute("emloyeeById",emloyeeById);
        model.addAttribute("allDepartment",allDepartment);
        return "updateE";
    }

    //    删除
    @RequestMapping("/todeleteE")
    public String delete(Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/getAllEmployees";
    }

}
