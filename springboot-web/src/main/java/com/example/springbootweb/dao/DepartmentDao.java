package com.example.springbootweb.dao;

import com.example.springbootweb.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YZY
 * @date 2020/5/3 - 14:46
 */
@Repository
public class DepartmentDao {

//    模拟数据
    private static Map<Integer, Department> departmentMap = null;
    static{
        departmentMap = new HashMap<>();
        departmentMap.put(101,new Department(101,"开发"));
        departmentMap.put(102,new Department(102,"运维"));
        departmentMap.put(103,new Department(103,"测试"));
    }

//    业务
//    获取所有部门信息
    public Collection<Department> findAllDepartment(){
        return departmentMap.values();
    }

//    通过id获取部门信息
    public Department findDepartMentByID(Integer id){
        return departmentMap.get(id);
    }

}
