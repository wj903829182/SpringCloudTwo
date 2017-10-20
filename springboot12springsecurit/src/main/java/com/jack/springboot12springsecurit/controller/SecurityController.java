package com.jack.springboot12springsecurit.controller;

import com.jack.springboot12springsecurit.pojo.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by jack 2017/10/18
 */
@Controller
@RequestMapping("security")
public class SecurityController {
    @RequestMapping("/index")
    //@RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }
}
