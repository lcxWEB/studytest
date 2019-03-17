package com.star.spring.bean;

import org.springframework.stereotype.Component;

/**
 * Created by lcx on 2018/10/11.
 */

@Component("helloService")
public class HelloService {

    private String name;

    @Override
    public String toString() {
        return "HelloService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


//    public HelloService(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHi(){
        System.out.println("Hi -- HelloService" + name);
    }
}
