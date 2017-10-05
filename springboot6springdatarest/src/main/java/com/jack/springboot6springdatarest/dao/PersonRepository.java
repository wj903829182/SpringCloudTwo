package com.jack.springboot6springdatarest.dao;

import com.jack.springboot6springdatarest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * create by jack 2017/10/5
 */
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person,Integer>{

    @RestResource(path = "nameStartsWith",rel = "nameStartsWith")
    List<Person> findByNameStartingWith(@Param("name") String name);
}
