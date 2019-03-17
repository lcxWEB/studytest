package com.star.spring.aop.demo2;

/**
 * Created by lcx on 2018/10/13.
 */
public class ProductDao {

    public void findAll() {
        System.out.println("查询商品----");
    }


    public void save() {
        System.out.println("新增商品----");

    }

    public void update() {
        System.out.println("更新商品----");
    }


    public void delete() {
        System.out.println("删除商品----");
    }
}
