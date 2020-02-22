package com.star.spring.aop.demo5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lcx on 2018/10/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application3.xml")
public class SpringDemoTest {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void demo1(){
        customerDao.find();
        customerDao.delete();
        customerDao.update();
        customerDao.save();


        studentDao.findAll();
        studentDao.delete();
        studentDao.update();
        studentDao.save();
    }
}
