package com.example.springbootweb;

import com.example.springbootweb.pojo.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
//        调用public Department(Integer id, String departmentName)这个构造函数，创建对象时就赋值
        Department department = new Department(1,"YZY");


//        调用无参构造创建一个空的对象
        Department department1 = new Department();
//        空对象需要手动赋值
        department1.setId(1);
        department1.setDepartmentName("YZY");
    }

}
