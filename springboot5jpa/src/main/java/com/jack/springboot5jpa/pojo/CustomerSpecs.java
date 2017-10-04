package com.jack.springboot5jpa.pojo;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by jack 2017/10/3
 */
public class CustomerSpecs {
    /**
     * 定义一个返回值为Specification的方法byAuto，这里使用的是范型T，所以这个Specification
     * 是可以用于任意的实体类的。它接受的参数是entityManager和当前的包含值作为查询条件的实体类对象
     *
     * @param entityManager
     * @param example
     * @param <T>
     * @return
     */
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        /**
         * 获得当前实体对象类的类型
         */
        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //新建Predicate列表存储构造的查询条件
                List<Predicate> predicates = new ArrayList<>();
                //获得实体类的EntityType，我们可以从EntityType获得实体类的属性
                EntityType<T> entityType = entityManager.getMetamodel().entity(type);
                //对实体类所有的属性做循环
                for (Attribute<T, ?> attribute : entityType.getDeclaredAttributes()) {
                    //获得实体类对象某一个属性的值
                    Object attrValue = getValue(example, attribute);
                    if (attrValue != null) {
                        //当前属性值为字符类型的时候
                        if (attribute.getJavaType() == String.class) {
                            //若当前字符不为空的时候
                            if (!StringUtils.isEmpty(attrValue)) {
                                //构造当前属性like（前后%）属性值查询条件，并添加到条件列表中
                                predicates.add(criteriaBuilder.like(root.get(attribute(entityType, attribute.getName(), String.class)), pattern((String) attrValue)));
                            }
                        } else {
                            //其余情况下构造属性和属性值equal查询条件，并添加到条件列表中
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entityType, attribute.getName(), attrValue.getClass())), attrValue));
                        }
                    }
                }
                //predicates.toArray(new Predicate[predicates.size()转换为数组
                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    /**
     * 通过反射获得实体对象对应属性的属性值
     *
     * @param example
     * @param attribute
     * @param <T>
     * @return
     */
    private static <T> Object getValue(T example, Attribute<T, ?> attribute) {
        return ReflectionUtils.getField((Field) attribute.getJavaMember(), example);
    }

    /**
     * 获得实体类的当前属性SingularAttribute，SingularAttribute包含的是实体类的某个单独属性
     *
     * @param entityType
     * @param fieldName
     * @param fieldClass
     * @param <E>
     * @param <T>
     * @return
     */
    private static <E, T> SingularAttribute<T, E> attribute(EntityType<T> entityType, String fieldName, Class<E> fieldClass) {
        return entityType.getDeclaredSingularAttribute(fieldName, fieldClass);
    }

    /**
     * 构造like的查询模式，即前后加%
     *
     * @param str
     * @return
     */
    private static String pattern(String str) {
        return "%" + str + "%";
    }

    /**
     *
     * @param predicates
     * @param fieldClass
     * @param <T>
     * @return
     */
    public static<T> Predicate[] toArray(List<T> predicates,Class<T> fieldClass){

        Predicate[] result = (Predicate [])predicates.toArray();

        return result;
    }

}
