package com.star.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof关键字演示
 * @Author: lcx
 * @Date: 2019/3/3 17:50
 * @Description:
 */

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    // String fileName = name + ".class";
                    // System.out.println(fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };


        Object obj = myLoader.loadClass("com.star.jvm.classloading.ClassLoaderTest").newInstance();
        Object obj1 = myLoader.loadClass("java.lang.Object").newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof com.star.jvm.classloading.ClassLoaderTest);

        System.out.println(myLoader.getParent());

        System.out.println(ClassLoader.getSystemClassLoader());

        Object o = new Object();
    }

}
