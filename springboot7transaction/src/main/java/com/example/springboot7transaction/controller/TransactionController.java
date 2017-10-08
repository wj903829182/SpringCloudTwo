package com.example.springboot7transaction.controller;

import com.example.springboot7transaction.entity.Person;
import com.example.springboot7transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by jack 2017/10/8
 */
@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    private DemoService demoService;

    /**
     * 测试回滚情况
     * @param person
     * @return
     */
    @RequestMapping("/rollback")
    public Person rollback(Person person){
        return demoService.savePersonWithRollBack(person);
    }

    /**
     * 测试不回滚情况
     * @param person
     * @return
     */
    @RequestMapping("/norollback")
    public Person noRollback(Person person){
        return demoService.savePersonWithoutRollBack(person);
    }

}
