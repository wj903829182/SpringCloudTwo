package com.jack.springboot8cache.dao;


import com.jack.springboot8cache.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by jack 2017/10/8
 * 实体类
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
