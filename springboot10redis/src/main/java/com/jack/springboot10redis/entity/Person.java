package com.jack.springboot10redis.entity;

import java.io.Serializable;

/**
 * create by jack 2017/10/11
 * 此类需要用时间序列化接口，因为使用Jackson做序列化需要一个空构造函数
 */
public class Person implements Serializable{

    private String id;
    private String name;
    private Integer age;

    public Person() {
        super();
    }

    public Person(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
