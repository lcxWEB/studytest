package com.star.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lcx on 2018/10/11.
 */
public class SpringMainTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//        反射
//        String className = "com.star.spring.bean.Person";
//        Object o = Class.forName(className).newInstance();
//        ((Person)o).setName("小小");
//        System.out.println(((Person) o).getName());

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        person.sayHello();


//        Person person = (Person) applicationContext.getBean("person2");
        System.out.println(person);

//        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        userDao.delete();
//        userDao.save();
//        userDao.update();


        Person person1 = (Person) applicationContext.getBean("person");
        System.out.println(person);
        System.out.println(person1);

        System.out.println(person == person1);

//        ((Person)ApplicationContextUtil.getApplicationContext().getBean("person")).sayHello();

//        使用FileSystemXmlApplicationContext
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\springbootproject\\src\\main\\resources\\applicationContext.xml");

//        使用beanfactory
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        ((ClassPathXmlApplicationContext)applicationContext).close();

//        CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
//        System.out.println(collectionBean);

    }
//
//    @Test
//    public void beanPost(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        userDao.delete();
//
//    }
}

