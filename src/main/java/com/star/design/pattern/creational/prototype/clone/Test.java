package com.star.design.pattern.creational.prototype.clone;

import com.star.datastructure.stackqueue.Array;
import com.star.design.pattern.creational.singleton.HungrySingleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: lcx
 * @Date: 2019/1/15 19:20
 * @Description:
 */

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Date birthday = new Date(0L);
        ArrayList arrayList = new ArrayList();
        arrayList.add("888");
        arrayList.add(new Date(998888899L));
        Pig pig1 = new Pig("pp1", birthday, arrayList, arrayList);
        Pig pig2 = (Pig) pig1.clone();
        System.out.println(pig1);
        System.out.println(pig2);

        pig1.getBirthday().setTime(886666666666L);
        pig1.getList().add("nnnnnnn====9999");
        pig1.getDates().add(new Date(9966666999L));

        System.out.println(pig1);
        System.out.println(pig2);

        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton cloned = (HungrySingleton) method.invoke(hungrySingleton);
        System.out.println(hungrySingleton);
        System.out.println(cloned);
    }

}
