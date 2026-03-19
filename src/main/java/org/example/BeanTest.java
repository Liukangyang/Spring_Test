package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.service.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("beanTest")
public class BeanTest {

    UserDao userDao;
    //工厂方法
    @Bean("dataSource")
    public DataSource dataSource(@Value("root")String user, @Value("123456")String password,@Qualifier("userDao") UserDao userDao){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        this.userDao = userDao;
        return dataSource;
    }


    void show(){
        System.out.println("userDao:"+userDao);
    }
}
