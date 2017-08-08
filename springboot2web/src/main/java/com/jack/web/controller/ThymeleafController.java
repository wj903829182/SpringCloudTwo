package com.jack.web.controller;

import com.jack.web.pojo.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ThymeleafController {
    @RequestMapping("/thymeleaf")
    public String index(Model model){
        Person single = new Person("jack", 11);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx", 12);
        Person p2 = new Person("xx", 13);
        Person p3 = new Person("xx", 14);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }
}
