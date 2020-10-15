package com.jyinfo.jy_controller.websocket.controller;

import com.jyinfo.jy_controller.websocket.domain.InMessage;
import com.jyinfo.jy_controller.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * ClassName: SingleChatController
 * Author:   Huang
 * Date:     2020-10-13 9:49
 * Version: 1.0
 * Description: 单人聊天
 */
@Controller
public class SingleChatController {

    @Autowired
    private WebSocketService webSocketService;

    @MessageMapping("/v1/single/chat")
    public void singleChat(InMessage message) {
        System.err.println(message.getFrom() + "=================================" + message.getContent());
        webSocketService.sendTopicMessage(message);
    }
}
