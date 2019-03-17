package com.star.spring.aspectj.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lcx on 2018/10/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationAspect2.xml")
public class SpringDemoTest {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo1(){
        customerDao.findOne();
        customerDao.delete();
        customerDao.save();
        customerDao.update();
        customerDao.findAll();
    }
}
