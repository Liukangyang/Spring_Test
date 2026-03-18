package org.example;

import org.example.service.UserDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("userDao")
@Scope("singleton")
@Lazy(true)
public class UserDaoImpl implements UserDao {

@PostConstruct
    public void init(){
        System.out.println("UserDao init");
    }

@PreDestroy
    public void destroy(){
        System.out.println("UserDao destroy");
    }

    @Override
    public String toString() {
        return "UserDaoImpl";
    }
}
