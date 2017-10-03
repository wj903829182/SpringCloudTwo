package com.jack.springboot5jpa.pojo;

import com.jack.springboot5jpa.entity.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * create by jack 2017/10/3
 */
public class CustomerSpecs {
    public static Specification<Person> personFromSZ(){
        return new Specification<Person>(){
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("address"),"深圳");
            }
        };
    }
}
