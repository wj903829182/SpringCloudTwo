package com.jack.springboot9mongodb.dao;


import com.jack.springboot9mongodb.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * create by jack 2017/10/10
 */
public interface PersonRepository extends MongoRepository<Person,Integer> {
    /**
     * 支持方法名查询
     * @param name
     * @return
     */
    Person findByName(String name);

    /**
     * 支持@Query查询，查询参数构造JSON字符串即可
     * @param age
     * @return
     */
    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);
}
