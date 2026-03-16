package org.example;

import junit.framework.TestCase;
import org.example.service.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest extends TestCase {
    public void testBeanFactory(){
//        System.out.println("hello");
        //1.创建beanfactory
        DefaultListableBeanFactory beanfactory  = new DefaultListableBeanFactory();

        //2.创建读取器
        XmlBeanDefinitionReader reader =  new XmlBeanDefinitionReader(beanfactory);


        //3.加载配置文件
        reader.loadBeanDefinitions("beans.xml");


        //4.获取bean实例对象
        UserService userService = (UserService)beanfactory.getBean("userService");

        System.out.println(userService);

        //DI注入
        UserDao userDao = (UserDao) beanfactory.getBean("userDao");
        System.out.println(userDao);



    }

    public void testApplicationContext(){
        //1.
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");


        //2.
//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService1 = (UserService) applicationContext.getBean("userService");
        UserService userService2 = (UserService) applicationContext.getBean("userService");
        UserService userService3 = (UserService) applicationContext.getBean("userService");

        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(userService3);

        //显式关闭容器：才能调用userService的销毁方法
        applicationContext.close();

    }

    public void testFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService1 =(UserService)applicationContext.getBean("userService1");
        UserService userService2 =(UserService)applicationContext.getBean("userService2");
        UserService userService3 = (UserService)applicationContext.getBean("userService3");
        UserServiceImpl userService4 = (UserServiceImpl) applicationContext.getBean("userService4");
        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(userService3);
        System.out.println(userService4);
        userService4.showList();
    }


    public void testAutoWire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userService = (UserServiceImpl)applicationContext.getBean("userService5");
        System.out.println(userService.getUserDao());
    }

}
