package org.example.factory;

import org.example.UserServiceImpl;
import org.example.service.UserService;

public class MyBeanFactory2 {
    //实例工厂
    public UserService getUserService(){
        System.out.println("Instance factory method for userService!");
        return new UserServiceImpl();
    }
}
