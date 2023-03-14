package com.zjt.project00;

import com.zjt.project00.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Project00Application.class)
@RunWith(SpringRunner.class)
class Project00ApplicationTests {

    @Autowired
    HelloService helloService;

    @Test
    void contextLoads() {
        helloService.helloServiceThread();
    }

}
