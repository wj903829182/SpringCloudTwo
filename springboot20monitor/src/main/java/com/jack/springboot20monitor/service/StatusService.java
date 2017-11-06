package com.jack.springboot20monitor.service;

import org.springframework.stereotype.Service;

/**
 * create by jack 2017/11/6
 */
@Service
public class StatusService {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
