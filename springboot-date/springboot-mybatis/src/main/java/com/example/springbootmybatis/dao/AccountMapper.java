package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YZY
 * @date 2020/5/7 - 10:56
 */
// 代表这是一个mybatis的mapper类
@Mapper
@Repository
public interface AccountMapper {

    List<Account> queryAllAccount();

    int addAccount(Account account);

    int deleteAccount(int id);

    int updateAccount(Account account);

}
