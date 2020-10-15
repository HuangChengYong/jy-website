package com.jyinfo.jy_controller.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * ClassName: WebSocketConfig
 * Author:   Huang
 * Date:     2020-09-18 10:45
 * Version: 1.0
 * Description: websocket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 注册端点，发布或订阅消息的实收需要连接此端点
     * setAllowedOrigins 非必须，*表示允许其他域进行连接
     * withSockJS 表示开始sockJS支持
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint-websocket").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置消息代理（中介）
     * enableSimpleBroker   服务端推送给客户端的路径前缀
     * setApplicationDestinationPrefixes    客户端发送数据给服务器的一个路径前缀
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/chat");
        registry.setApplicationDestinationPrefixes("/jyinfo/app");
    }
}
