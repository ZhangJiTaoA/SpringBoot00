package com.zjt.project02redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Project02RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet(){
        redisTemplate.boundValueOps("name").set("zjt");
    }

    // 需要本地有redis
    @Test
    public void testGet(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

}
