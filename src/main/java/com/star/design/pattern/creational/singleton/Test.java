package com.star.design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: lcx
 * @Date: 2018/12/19 10:26
 * @Description:
 */

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // LazySingleton lazySingleton = LazySingleton.getInstance();

        System.out.println("mainer thread " + ThreadLocalInstance.getIntance());
        System.out.println("mainer thread " + ThreadLocalInstance.getIntance());
        System.out.println("mainer thread " + ThreadLocalInstance.getIntance());
        System.out.println("mainer thread " + ThreadLocalInstance.getIntance());
        System.out.println("mainer thread " + ThreadLocalInstance.getIntance());
        System.out.println("mainer thread " + ThreadLocalInstance.getIntance());
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());

        t1.start();
        t2.start();
        System.out.println("program end");

        // HungrySingleton instance = HungrySingleton.getInstance();

        // EnumInstance instance = EnumInstance.getInstance();
        // instance.setData(new Object());
        //
        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        // oos.writeObject(instance);
        //
        // File file = new File("singleton_file");
        // ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        //
        // HungrySingleton newInstance = (HungrySingleton) ois.readObject();
        //
        // EnumInstance newInstance = (EnumInstance) ois.readObject();
        //
        // System.out.println(instance.getData());
        // System.out.println(newInstance.getData());
        // System.out.println(instance.getData() == newInstance.getData());


        // // Class objectClass = HungrySingleton.class;
        //  Class objectClass = EnumInstance.class;
        //
        // // Class objectClass = StaticInnerClassSingleton.class;
        //
        // // Class objectClass = LazySingleton.class;
        //
        // Constructor constructor = objectClass.getDeclaredConstructor(String.class, int.class);
        // constructor.setAccessible(true);
        //
        // EnumInstance newInstance = (EnumInstance) constructor.newInstance();
        // // LazySingleton newInstance = (LazySingleton) constructor.newInstance();
        // // LazySingleton instance = LazySingleton.getInstance();
        // EnumInstance instance = EnumInstance.getInstance();
        //
        // // StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        // // StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();
        //
        // // HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
        // // HungrySingleton instance = HungrySingleton.getInstance();
        // //
        // System.out.println(instance);
        // System.out.println(newInstance);
        // System.out.println(instance == newInstance);

        // EnumInstance instance = EnumInstance.getInstance();
        // instance.printTest();

    }

}
