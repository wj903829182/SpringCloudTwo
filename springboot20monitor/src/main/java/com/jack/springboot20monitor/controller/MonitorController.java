package com.jack.springboot20monitor.controller;

import com.jack.springboot20monitor.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by jack 2017/11/6
 */
@RestController
@RequestMapping("monitor")
public class MonitorController {

    @Autowired
    private StatusService statusService;

    @RequestMapping("/change")
    public String changeStatus(String status){
        statusService.setStatus(status);
        return "OK";
    }


}
