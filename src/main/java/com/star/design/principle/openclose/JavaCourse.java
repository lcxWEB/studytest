package com.star.design.principle.openclose;/**
 * Created by lcx on 2018/11/22.
 */

/**
 * @Author: lcx
 * @Date: 2018/11/22 11:46
 * @Description: TODO
 */

public class JavaCourse implements ICourse {

    private Integer Id;
    private String name;
    private Double price;

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    public JavaCourse(Integer id, String name, Double price) {
        this.Id = id;
        this.name = name;
        this.price = price;
    }
}
