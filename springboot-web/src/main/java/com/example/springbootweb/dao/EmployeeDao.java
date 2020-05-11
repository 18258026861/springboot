package com.example.springbootweb.dao;

import com.example.springbootweb.pojo.Department;
import com.example.springbootweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YZY
 * @date 2020/5/3 - 16:14
 */
@Repository
public class EmployeeDao {

    private static Map<Integer , Employee> employeeMap= null;
//    员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employeeMap = new HashMap<>();
        employeeMap.put(1,new Employee(1,"YZY","email1@qq.com",1,new Department(101,"开发")));
        employeeMap.put(2,new Employee(2,"YY","email2@qq.com",0,new Department(102,"运维")));
        employeeMap.put(3,new Employee(3,"JJ","email3@qq.com",0,new Department(101,"开发")));
        employeeMap.put(4,new Employee(4,"HC","email4@qq.com",1,new Department(103,"测试")));
    }

//    业务\
//    主键自增
    private static Integer initid = 5;
//    增加一个员工
    public void addEmployee(Employee employee){
        employee.setId(initid++);
//        前端传过来的是部门id，要通过id把部门名字自动输入
        employee.setDepartment(departmentDao.findDepartMentByID(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
//    删除一个员工
    public void deleteEmployee(Integer id){
        employeeMap.remove(id);
    }
//    修改员工
    public void updateEmployee(Employee employee){
        employeeMap.replace(employee.getId(),employee);
    }
//    查询所有员工
    public Collection<Employee> findAllEmloyee(){
       return employeeMap.values();
    }
//    通过id查找员工
    public Employee findEmloyeeById(Integer id){
        return employeeMap.get(id);
    }

}
