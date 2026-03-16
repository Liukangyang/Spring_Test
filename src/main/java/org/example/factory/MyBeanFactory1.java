package org.example.factory;

import org.example.UserServiceImpl;
import org.example.service.UserService;

public class MyBeanFactory1 {

    //静态工厂
    public static UserService getUserService(){
        System.out.println("Static factory method for userService!");
        return new UserServiceImpl();
    }
}
