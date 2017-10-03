package com.jack.springboot5jpa.pojo;

import com.jack.springboot5jpa.impl.CustomRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * create by jack 2017/10/3
 */
public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<T, S, ID>
{//自定义RepositoryFactoryBean，继承JpaRepositoryFactoryBean


    public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    /**
     * 重写createRepositoryFactory方法，用当前的CustomRepositoryFactory创建实例
     * @param entityManager
     * @return
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomRepositoryFactory(entityManager);
    }

    /**
     * 创建CustomRepositoryFactory，并继承JpaRepositoryFactory
     */
    public static class CustomRepositoryFactory extends JpaRepositoryFactory{
        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        /**
         * 重写getTargetRepository，获得当前自定义的epository实现
         * @param information
         * @param entityManager
         * @param <T>
         * @param <ID>
         * @return
         */
        @Override
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
            return new CustomRepositoryImpl<T,ID>((Class<T>) information.getDomainType(),entityManager);
        }

        /**
         * 重写getRepositoryBaseClass，获得当前自定义的Repository实现的类型
         * @param metadata
         * @return
         */
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepositoryImpl.class;
        }
    }
}
