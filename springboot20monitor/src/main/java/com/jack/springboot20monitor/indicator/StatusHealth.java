package com.jack.springboot20monitor.indicator;

import com.jack.springboot20monitor.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * create by jack 2017/11/8
 */
@Component
//实现HealthIndicator接口并重写health()方法
public class StatusHealth implements HealthIndicator {
    @Autowired
    private StatusService statusService;
    @Override
    public Health health() {
        String status = statusService.getStatus();
        if (status == null || !status.equals("running")){
            //当status的值为非running时构造失败
            return Health.down().withDetail("Error","Not Running").build();
        }
        //其余情况运行成功
        return Health.up().build();
    }
}
