package com.alice.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@SpringBootTest
class SpringJdbcDemoApplicationTests {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {

        List<Object> query = jdbcTemplate.query("", (resultSet, i) -> {
            Object object = resultSet.getObject(i);
            log.info("{}", object);
            return null;
        });
    }

}
