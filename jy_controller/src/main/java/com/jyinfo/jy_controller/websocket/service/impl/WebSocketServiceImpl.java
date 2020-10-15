package com.jyinfo.jy_controller.websocket.service.impl;

import com.jyinfo.jy_controller.websocket.domain.InMessage;
import com.jyinfo.jy_controller.websocket.domain.OutMessage;
import com.jyinfo.jy_controller.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * ClassName: WebSocketServiceImpl
 * Author:   Huang
 * Date:     2020-10-13 9:46
 * Version: 1.0
 * Description: websocket业务层实现类
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendTopicMessage(InMessage message) {
        simpMessagingTemplate.convertAndSend("/chat/single/" + message.getTo(), new OutMessage(message.getFrom(), message.getContent()));
    }
}
