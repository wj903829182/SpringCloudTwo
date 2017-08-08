package com.jack.web.controller;

import com.jack.web.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    @RequestMapping("/thymeleaf")
    public String index(Model model){
        Person single = new Person("jack", 11);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx", 12);
        Person p2 = new Person("yy", 13);
        Person p3 = new Person("zz", 14);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }
}
