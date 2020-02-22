package com.star.java;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * @Author: lcx
 * @Date: 2019/2/13 20:52
 * @Description:
 */

public class Employee implements Cloneable
        // extends Person{
{
    private static int nextId;

    private String name;

    private int id;

    private double salary;

    private Date hireDay;

    protected int hireDays;

    public Employee getBuddy() {
        return new Employee();
    }


    {
        name = "ddd";
        id = nextId;
        nextId++;
        System.out.println("id : " + id);
    }
    static {
        nextId = new Random().nextInt(10000);
    }

    public Employee(String name) {
        this.name = name;
        System.out.println("construct with name : " + this.name);
    }

    public Employee() {
        System.out.println("construct : ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    /**
     * @see java.applet.Applet#getSize()
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, CloneNotSupportedException {
        Employee employee = new Employee("mmm");
        // new Employee("ttt");
        //
        // System.out.println(employee.getName().hashCode());
        // char[] chars = new char[111];
        // for (int i = 0; i < chars.length; i++) {
        //     chars[i] = 'a';
        // }
        // System.out.println(100 + chars[1]);
        //
        // System.out.println("Hello".hashCode());
        // System.out.println("Harry".hashCode());
        // System.out.println("Hacker".hashCode());
        //
        // System.out.println(employee.getClass().getName());
        // System.out.println(Class.forName("com.star.java.Employee"));
        // System.out.println(Employee.class.newInstance());
        // System.out.println(double[].class);
        // System.out.println(int[].class);
        // System.out.println(int.class);
        // Class cl = employee.getClass();
        // Field f = cl.getDeclaredField("name");
        // Field sal = cl.getDeclaredField("salary");
        // System.out.println(sal.isAccessible());
        // // f.setAccessible(true);
        // Object o = f.get(employee);
        // Object o2 = sal.get(employee);
        // System.out.println(o);
        // System.out.println(o2);
        employee.setHireDay(new Date());
        Employee cloned = employee.clone();
        employee.setName("ddsds");
        System.out.println(cloned.getName());
        System.out.println(employee.getName());
        Employee.class.getResource("sss.tct");

    }

    public String getDesc() {
        return "employee";
    }


    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }
}
