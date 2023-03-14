package com.zjt.text;

import com.zjt.project01junit.Project01JunitApplication;
import com.zjt.project01junit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * useerService的测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Project01JunitApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
