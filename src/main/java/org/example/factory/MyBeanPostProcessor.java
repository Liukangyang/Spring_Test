package org.example.factory;

import org.example.UserServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

public class MyBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        if(bean instanceof UserServiceImpl) {
            //赋值
            UserServiceImpl userService = (UserServiceImpl) bean;
            List<String> list = new ArrayList<>();
            list.add("aaa");list.add("bbb");list.add("cccc");
            userService.setStringList(list);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring 容器:"+applicationContext);
    }
}
