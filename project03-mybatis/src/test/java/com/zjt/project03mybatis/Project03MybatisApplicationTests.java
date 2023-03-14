package com.zjt.project03mybatis;

import com.zjt.project03mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Project03MybatisApplication.class)
@RunWith(SpringRunner.class)
class Project03MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {

    }

}
