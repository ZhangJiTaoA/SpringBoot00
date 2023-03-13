package com.zjt.project00.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.age}")
    private int age;

    @Value("${person.name}")
    private String name;

    @Autowired
    private Environment env;

    @RequestMapping("/zjt/helloworld")
    String helloWorld(){
        System.out.println(age);
        System.out.println(name);
        System.out.println(env.getProperty("person.name"));

        return "Hello World!";
    }
}
