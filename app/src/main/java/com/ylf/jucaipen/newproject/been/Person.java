package com.ylf.jucaipen.newproject.been;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by Administrator on 2015/11/17.
 */
public class Person extends RealmObject implements Serializable {
    private  int id;
    private  String name;
    private  int sex;
    private  int age;
    private  String address;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public Person(int id, String name, int sex, int age, String address) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
