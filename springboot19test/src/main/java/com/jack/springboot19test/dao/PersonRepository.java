package com.jack.springboot19test.dao;

import com.jack.springboot19test.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by jack 2017/11/5
 */
public interface PersonRepository extends JpaRepository<Person,Integer>{
}
