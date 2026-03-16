package org.example.factory;

import org.example.UserServiceImpl;
import org.example.service.UserService;
import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory3 implements FactoryBean<UserService> {


    @Override
    public UserService getObject() throws Exception {
        System.out.println("factoryBean method for userService!");
        return new UserServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
