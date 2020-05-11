package com.example.springbootmybatis;

import com.example.springbootmybatis.dao.AccountMapper;
import com.example.springbootmybatis.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    AccountMapper accountMapper;

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
        List<Account> accounts = accountMapper.queryAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }

    }

}
