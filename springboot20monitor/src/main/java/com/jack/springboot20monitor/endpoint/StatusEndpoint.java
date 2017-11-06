package com.jack.springboot20monitor.endpoint;


import com.jack.springboot20monitor.service.StatusService;
import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * create by jack 2017/11/6
 */

/**
 * 通过设置@ConfigurationProperties的设置，我们可以在application.properties中通过endpoints。status配置我们的端点，
 * 继承AbstractEndpoint类，AbstractEndpoint是Endpoint接口的抽象实现，当前类一定要重写invoke方法。实现ApplicationContextAware
 * 接口可以让当前类对spring容器的资源有意识，即可访问容器的资源
 */
@ConfigurationProperties(prefix = "endpoints.status",ignoreUnknownFields = false)
public class StatusEndpoint extends AbstractEndpoint<String> implements ApplicationContextAware {

    ApplicationContext context;
    public StatusEndpoint() {
        super("status");
    }

    /**
     * 通过重写invoke方法，返回我们要监控的内容
     * @return
     */
    @Override
    public String invoke() {
        StatusService statusService = context.getBean(StatusService.class);
        return "The Current Status is :"+statusService.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}
