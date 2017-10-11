package com.jack.springboot10redis.dao;

import com.jack.springboot10redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * create by jack 2017/10/11
 */
@Repository
public class PersonDao {
    /**
     * spring boot已为我们配置StringRedisTemplate，在此处可以直接注入
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 可以使用@Resource注解指定stringRedisTemplate，可注入基于字符串的简单属性操作方法
     */
    @Resource(name="stringRedisTemplate")
    private ValueOperations<String,String> valOpsStr;

    /**
     * spring boot已为我们配置RedisTemplate，在此处可以直接注入
     */
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 可以使用@Resource注解指定redisTemplate，可注入基于对象的简单属性操作方法
     */
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    /**
     * 通过set方法，存储字符串
     */
    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }

    /**
     * 通过set方法，存储对象
     * @param person
     */
    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    /**
     * 通过get方法，获得字符串
     * @return
     */
    public String getString(){
        return valOpsStr.get("xx");
    }

    /**
     * 通过get方法，获得对象
     * @return
     */
    public Person getPerson(){
        return (Person) valOps.get("1");
    }

}
