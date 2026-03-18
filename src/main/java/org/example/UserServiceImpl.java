package org.example;

import org.example.mapper.UserMapper;
import org.example.service.UserDao;
import org.example.service.UserService;
import org.example.utils.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public class UserServiceImpl implements UserService, InitializingBean,ApplicationContextAware, BeanNameAware {

    private UserDao userDao;
    private String name;
    private List<String> stringList;
    //
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserServiceImpl() {
        System.out.println("userService 构造");
    }

    public UserServiceImpl(String name) {
        System.out.println("set name:"+name);
        this.name = name;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("set list:"+stringList);
        this.stringList = stringList;
    }

    public void setName(String name) {
        System.out.println("setname:"+name);
        this.name = name;
    }

    public void showList(){
        stringList.forEach(ss-> System.out.println(ss));
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("set UserDao");
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    //初始化方法
    public void init(){
        System.out.println("userService init_method");
    }

    //销毁方法
    public void destroy(){
        System.out.println("userService destroy");
    }


    //Bean初始化接口
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initialize Bean!");
    }

    //Aware接口


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring 容器："+applicationContext);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanName:"+s);
    }

    @Override
    public void show() {
       List<User> users= userMapper.findAll();
       users.forEach(user->{
           System.out.println(user);
       });

    }
}
