package com.star.spring.bean;

/**
 * Created by lcx on 2018/10/12.
 */
public class UserDaoImp implements UserDao {

    @Override
    public void findAll() {
        System.out.println("查询用户----");
    }

    @Override
    public void save() {
        System.out.println("新增用户----");

    }

    @Override
    public void update() {
        System.out.println("更新用户----");
    }

    @Override
    public void delete() {
        System.out.println("删除用户----");
    }
}
