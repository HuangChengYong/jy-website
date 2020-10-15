package com.jyinfo.jy_controller.websocket.service;

import com.jyinfo.jy_controller.websocket.domain.InMessage;

/**
 * ClassName: WebSocketService
 * Author:   Huang
 * Date:     2020-10-13 9:45
 * Version: 1.0
 * Description: websocket业务层接口
 */
public interface WebSocketService {

    void sendTopicMessage(InMessage message);
}
