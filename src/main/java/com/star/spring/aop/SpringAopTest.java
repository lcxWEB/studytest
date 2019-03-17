package com.star.spring.aop;

import com.star.spring.aop.demo1.MyJdkProxy;
import com.star.spring.aop.demo1.UserDao;
import com.star.spring.aop.demo1.UserDaoImp;
import com.star.spring.aop.demo2.MyCglibProxy;
import com.star.spring.aop.demo2.ProductDao;
import org.junit.Test;

/**
 * Created by lcx on 2018/10/13.
 */
public class SpringAopTest {

    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImp();
//        userDao.save();
        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
        proxy.update();
        proxy.delete();
        proxy.save();
        proxy.findAll();
    }

    @Test
    public void demo2(){
        ProductDao productDao = new ProductDao();
        ProductDao proxy = (ProductDao) new MyCglibProxy(productDao).createProxy();
        proxy.delete();
        proxy.save();
        proxy.findAll();
        proxy.update();
    }


}
