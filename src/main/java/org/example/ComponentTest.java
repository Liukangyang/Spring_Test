package org.example;

import org.example.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//bean基本注解
@Component("componentTest")
public class ComponentTest {
    //属性注入示例
    @Value("componentName")
    private String name;

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Override
    public String toString() {
        return "ComponentTest";
    }

    void show(){
        System.out.println("name:"+name+", userDao:"+userDao);
    }
}
