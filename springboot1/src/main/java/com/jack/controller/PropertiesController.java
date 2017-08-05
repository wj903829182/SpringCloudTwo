package com.jack.controller;

import com.jack.config.AuthorSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jack on 2017/7/30.
 */
@RestController
public class PropertiesController {
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSetting authorSetting;

    @RequestMapping("/property")
    public String helloProperty(){
        System.out.println("helloProperty()");
        return "book name is :"+bookName+" and book author is :"+bookAuthor;
    }

    @RequestMapping("/author")
    public String author(){
        return "name: "+authorSetting.getName()+",age: "+authorSetting.getAge();
    }

}
