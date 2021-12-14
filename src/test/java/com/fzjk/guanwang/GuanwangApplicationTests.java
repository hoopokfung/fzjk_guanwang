package com.fzjk.guanwang;

import com.fzjk.guanwang.pojo.Type;
import com.fzjk.guanwang.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class GuanwangApplicationTests {


    @Autowired
    DataSource dataSource;

    @Autowired
    TypeService typeService;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

}
