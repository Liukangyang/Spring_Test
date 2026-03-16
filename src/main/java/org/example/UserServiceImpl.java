package org.example;

import org.example.service.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class UserServiceImpl implements UserService, InitializingBean {

    private UserDao userDao;
    private String name;
    private List<String> stringList;

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
        System.out.println("userService init");
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

}
