package com.jack.springboot5jpa.dao;

import com.jack.springboot5jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * create by jack 2017/10/3
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
    //使用方法名查询，接受一个name参数,返回值为一个列表
    List<Person> findByAddress(String address);

    /**
     *  使用方法名查询，接受一个name和address，返回值为单个对象
     *  通过名字和地址查询，参数为name和address
     *  相当于：JPQL:select p from Person p where p.name = ?1 and p.address=?2
     * @param name
     * @param address
     * @return
     */

    Person findByNameAndAddress(String name,String address);
    //使用@Query查询，参数按照名称绑定
    @Query("select p from Person  p where p.name = :name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name,@Param("address") String address);
    //使用@NamedQuery查询，注意实体类中做的@NamedQuery的定义
    Person withNameAndAddressNamedQuery(String name,String address);

    /**
     * 通过名字相等查询，参数为name
     * 相当于JPQL:select p from Person p where p.name = ?1
     * @param name
     * @return
     */
    List<Person> findByName(String name);

    /**
     * 通过名字like查询，参数为name
     * 相当于JPQL:select p from Person p where p.name like ?1
     * @param name
     * @return
     */
    List<Person> findByNameLike(String name);

    /**
     * 获得符合查询条件的前10条数据
     * @param name
     * @return
     */
    List<Person> findFirst10ByName(String name);

    /**
     * 获得符合查询条件的前30条数据
     * @param name
     * @return
     */
    List<Person> findTo30ByName(String name);
}
