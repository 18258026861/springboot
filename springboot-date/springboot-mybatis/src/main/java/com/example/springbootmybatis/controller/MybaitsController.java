package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dao.AccountMapper;
import com.example.springbootmybatis.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YZY
 * @date 2020/5/7 - 11:28
 */
@RestController
public class MybaitsController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/q")
    public List<Account> queryAllAccount(){
        List<Account> accounts = accountMapper.queryAllAccount();
        return accounts;
    }

    @RequestMapping("/a")
    public int addAccount(){
        int i = accountMapper.addAccount(new Account(17, "YY", 17));
        return i;
    }

    @RequestMapping("/d/{id}")
    public int deleteAccount(@PathVariable("id") int id){
        int i = accountMapper.deleteAccount(id);
        return i;
    }

    @RequestMapping("/u")
    public int updateAccount(){
        int y = accountMapper.updateAccount(new Account(2, "Y", 2));
        return y;
    }

}
