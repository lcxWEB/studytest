package com.star.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by lcx on 2018/9/15.
 */

@Component("person")
@Scope("prototype")
public class Person implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", helloService=" + helloService +
                '}';
    }

    @Value("注入属性：笑笑")
    private String name;

    @Value("17")
    private int age;

//    @Autowired
//    按名字注入
//    @Qualifier("helloService")
    @Resource(name = "helloService")
    private HelloService helloService;

    public Person(){
        System.out.println("第一步：Person 被实例化");
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        System.out.println("第二步：Person name被设置了");
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public void sayHello(){
        System.out.println("第九步： 执行业务处理 hello----");
        helloService.sayHi();
    }


    public void setUp(){
        System.out.println("第七步： 自己定义的初始化方法 Person被实例化了");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("构造器后 postConstruct-----");
    }

    public void tearDown(){
        System.out.println("第十一步： 自己定义的销毁方法 Person被销毁了");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("销毁之前 PreDestroy-----");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第三步： 设置beanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步： 了解工厂信息");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步： 属性设置后执行的方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第十步： 执行Spring的销毁方法");
    }
}
