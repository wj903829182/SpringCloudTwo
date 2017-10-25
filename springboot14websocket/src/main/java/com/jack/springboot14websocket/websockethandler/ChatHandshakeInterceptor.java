package com.jack.springboot14websocket.websockethandler;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * create by jack 2017/10/25
 */
public class ChatHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("Before Handshake");
        //System.out.println("0-----"+((ServletServerHttpRequest) request).getServletRequest().getSession().getId());
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            System.out.println("beforeHandshake ---"+session.getId());
            if (session != null){ //使用userName区分WebSocketHandler，以便定向发送消息 String userName =
                //String userName = session.getAttribute(Constants.SESSION_USERNAME);
                String userName = (String) session.getAttribute("jack");
                if (userName == null) {
                    userName = "default-system";
                }
                //attributes.put(Constants.WEBSOCKET_USERNAME, userName);
                attributes.put("jack", userName);

            }
        }

        //使用userName区分WebSocketHandler，以便定向发送消息(使用shiro获取session,或是使用上面的方式)
        /*String userName = (String) SecurityUtils.getSubject().getSession().getAttribute(Constants.SESSION_USERNAME);
        if (userName == null) {
            userName = "default-system";
        }
        attributes.put(Constants.WEBSOCKET_USERNAME, userName);*/

        return super.beforeHandshake(request, response, wsHandler, attributes);
        //return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("After Handshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
