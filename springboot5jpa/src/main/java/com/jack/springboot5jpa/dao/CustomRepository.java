package com.jack.springboot5jpa.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * create by jack 2017/10/3
 */
//指明@NoRepositoryBean当前这个接口不是我们领域类的接口（如：PersonRepository）
@NoRepositoryBean
//自定义的Repository实现PagingAndSortingRepository接口，具备分页和排序的能力
public interface CustomRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID>{
    //要定义的数据操作方法在接口中的定义
    public void doSomething(ID id);
}

