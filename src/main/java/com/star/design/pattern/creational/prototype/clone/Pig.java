package com.star.design.pattern.creational.prototype.clone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2019/1/15 19:17
 * @Description:
 */

public class Pig implements Cloneable {

    private String name;

    private Date birthday;

    private ArrayList<Object> list;

    private ArrayList<Date> dates;

    public ArrayList<Object> getList() {
        return list;
    }

    public void setList(ArrayList<Object> list) {
        this.list = list;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    public Pig(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Pig(String name, Date birthday, ArrayList<Object> list) {
        this.name = name;
        this.birthday = birthday;
        this.list = list;
    }

    public Pig(String name, Date birthday, ArrayList<Object> list, ArrayList<Date> dates) {
        this.name = name;
        this.birthday = birthday;
        this.list = list;
        this.dates = dates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig pig = (Pig) super.clone();

        //深克隆===============
        pig.birthday = (Date) pig.birthday.clone();
        pig.list = new ArrayList<>(list);
        pig.dates = new ArrayList<>(dates);
        return pig;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", list=" + list +
                ", dates=" + dates +
                '}' + super.toString();
    }
}
