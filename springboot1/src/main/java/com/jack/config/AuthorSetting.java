package com.jack.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/**
 *通过@ConfigurationProperties加装properties文件内的配置，通过prefix属性指定properties的配置
 * 的前缀，通过locations指定properties文件的位置
 */
@ConfigurationProperties(prefix = "author")
public class AuthorSetting {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
