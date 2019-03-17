package com.star.spring.aspectj.demo2;

/**
 * Created by lcx on 2018/10/14.
 */
public class CustomerDaoImp implements CustomerDao {

    @Override
    public void save() {
        System.out.println("保存----");
    }

    @Override
    public void update() {
        System.out.println("修改----");
    }

    @Override
    public void delete() {
        System.out.println("删除----");
    }

    @Override
    public void findOne() {
        System.out.println("查询一个----");
    }

    @Override
    public void findAll() {
        System.out.println("查询所有----");
    }
}
