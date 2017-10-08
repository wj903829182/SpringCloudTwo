package com.example.springboot7transaction.dao;

import com.example.springboot7transaction.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by jack 2017/10/8
 * 实体类
 */
public interface PersonRepository extends JpaRepository<Person,Integer>{
}
