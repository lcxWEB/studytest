package com.star.spring.aop.demo3;

/**
 * Created by lcx on 2018/10/13.
 */
public class StudentDaoImp implements StudentDao {

    @Override
    public void findAll() {
        System.out.println("查询学生=====");
    }

    @Override
    public void save() {
        System.out.println("新增学生=====");

    }

    @Override
    public void update() {
        System.out.println("修改学生=====");

    }

    @Override
    public void delete() {
        System.out.println("删除学生=====");

    }
}
