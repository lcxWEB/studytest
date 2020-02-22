package com.star.design.principle.openclose;/**
 * Created by lcx on 2018/11/22.
 */

/**
 * @Author: lcx
 * @Date: 2018/11/22 11:57
 * @Description: TODO
 */

public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }

}
