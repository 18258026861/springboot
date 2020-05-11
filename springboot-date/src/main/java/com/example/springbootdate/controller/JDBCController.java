package com.example.springbootdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author YZY
 * @date 2020/5/6 - 17:46
 */
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/s")
    public List<Map<String,Object>> s(){
        String sql = "select * from account";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

//    resultful传参
    @RequestMapping("/u/{id}")
    public int u(@PathVariable("id") int id){
        Object[] o  =new Object[2];
        o[0] = "Y";
        o[1] = 1;
        String sql = "update account set name=? ,money = ? where id = "+id;
//        占位符传参
        int update = jdbcTemplate.update(sql,o);
        return update;
    }

    @RequestMapping("/a")
    public int a(){
        Object[] o = new Object[3];
        o[0] = 17;
        o[1] = "JJ";
        o[2] = 17;
        String sql = "insert into account values(?,?,?)";
        int insert = jdbcTemplate.update(sql,o);
        return insert;
    }

    @RequestMapping("/d")
    public int d(){
        String sql = "delete from account where id = 17";
        int delete = jdbcTemplate.update(sql);
        return delete;
    }

}
