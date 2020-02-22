package com.star.design.principle.openclose;/**
 * Created by lcx on 2018/11/22.
 */

import java.math.BigDecimal;

/**
 * @Author: lcx
 * @Date: 2018/11/22 11:48
 * @Description: TODO
 */

public class Test {
    public static void main(String[] args) {
        ICourse javaCourse1 = new JavaDiscountCourse(96, "javajjjj", 348d);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse)javaCourse1;
        System.out.println("原价：" + javaCourse.getPrice());
        System.out.println(javaCourse.getId() + "-----" + javaCourse.getName() + "======折后价：" + new BigDecimal(Double.toString(javaCourse.getDiscountPrice())));
    }
}
