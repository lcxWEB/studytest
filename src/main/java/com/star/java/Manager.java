package com.star.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: lcx
 * @Date: 2019/2/14 10:00
 * @Description:
 */

public class Manager extends Employee {

    private double bonus;

    public Manager(String name) {
        bonus = 0;
        // super(name);
        hireDays = 100;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        Manager manager = new Manager("多少多少");
        manager.setBonus(88);
        manager.setSalary(80009);
        System.out.println("hireDays : " + manager.hireDays);
        System.out.println(manager.getSalary());
        employees[0] = manager;
        System.out.println(employees[0]);
        Manager[] managers = new Manager[4];
        employees = managers;
        // employees[0] = new Employee("sss");
        // managers[0].setBonus(1999);
        System.out.println(employees[0]);

        Object obj = new char[1];
        char[] chars = (char[]) obj;
        System.out.println(chars.getClass());
        System.out.println(manager.getClass());
        System.out.println(employees.getClass());
        System.out.println(Objects.equals(obj, manager));

        Arrays.equals(employees, managers);

        String s = "OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + "  " + sb.hashCode());

        String t = new String("OK");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + "  " + tb.hashCode());
        System.out.println(Objects.hash(manager.bonus, manager.getName()));

        ArrayList<Employee> arrayList = new ArrayList<>(100);
        // arrayList.set(0, new Employee());
        arrayList.add(manager);
        arrayList.add(new Employee());
        arrayList.trimToSize();
        arrayList.add(new Employee());

        Employee[] employees1 = arrayList.toArray(new Employee[10]);
        System.out.println(Arrays.toString(employees1));

    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        double salary = super.getSalary();
        return salary + bonus;
    }

    @Override
    public Manager getBuddy() {
        return new Manager("sss");
    }

}
