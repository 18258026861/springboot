package com.example.springbootdate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootDateApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        查看使用的数据库驱动          class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

//        连接数据库
        Connection connection = dataSource.getConnection();
//  HikariProxyConnection@533698361 wrapping com.mysql.cj.jdbc.ConnectionImpl@5b498842
        System.out.println(connection);

        connection.close();
    }

}
