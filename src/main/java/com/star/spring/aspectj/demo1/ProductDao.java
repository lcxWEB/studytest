package com.star.spring.aspectj.demo1;

import org.springframework.aop.framework.AopContext;

/**
 * Created by lcx on 2018/10/13.
 */
public class ProductDao {

    public void findAll() {
        System.out.println("查询所有商品----");
//        int i = 1/0;
    }

    public void findOne() {
        System.out.println("查询一个商品----");
//        int i = 1/0;
    }


    public void save() {
        // ((ProductDao)AopContext.currentProxy()).update();
        System.out.println("save中的更新：" + update());
        System.out.println("新增商品----");

    }

    public String update() {
        System.out.println("更新商品----");
        return "更新成功";
    }


    public void delete() {
        System.out.println("删除商品----");
    }
}
