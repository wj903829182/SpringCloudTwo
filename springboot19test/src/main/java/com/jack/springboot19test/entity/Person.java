package com.jack.springboot19test.entity;

import javax.persistence.*;

/**
 * create by jack 2017/10/3
 */
//@Entity注解指明这是一个和数据库表映射的实体类
@Entity
public class Person {
    /**
     * 主键id
     * @Id注解指明这个属性映射为数据库的主键
     * @GeneratedValue定义主键生成的方式，下面采用的是mysql的自增属性
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;

    public Person() {
        super();
    }

    public Person(Integer id, String name, Integer age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
