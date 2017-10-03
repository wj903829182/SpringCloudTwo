package com.jack.springboot5jpa.impl;

import com.jack.springboot5jpa.dao.CustomRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * create by jack 2017/10/3
 */
//首先要实现CustomRepository接口，继承SimpleJpaRepository类让我们可以使用其提供的方法
public class CustomRepositoryImpl <T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {

    //让数据库操作方法中可以使用entityManager
    private final EntityManager entityManager;

    /**
     * CustomRepositoryImpl的构造函数，需当前处理的领域类类型和entityManager作为构造函数，
     * 在这里也给我们的entityManager赋值了
     * @param domainClass
     * @param entityManager
     */
    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public void doSomething(Serializable serializable) {
        //在此定义数据访问操作，如调用findAll方法并构造一些查询条件
    }
}
