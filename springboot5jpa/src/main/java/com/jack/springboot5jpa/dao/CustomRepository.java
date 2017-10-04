package com.jack.springboot5jpa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * create by jack 2017/10/3
 */
//指明@NoRepositoryBean当前这个接口不是我们领域类的接口（如：PersonRepository）
@NoRepositoryBean
//自定义的Repository实现PagingAndSortingRepository接口，具备分页和排序的能力
public interface CustomRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{
   Page<T> findByAuto(T example,Pageable pageable);
}

