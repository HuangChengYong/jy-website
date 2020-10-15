package com.jyinfo.jy_controller.websocket.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: InMessage
 * Author:   Huang
 * Date:     2020-09-18 10:37
 * Version: 1.0
 * Description: 传入的消息对象
 */
public class InMessage implements Serializable {

    // 消息从哪里来
    private String from;

    // 消息要发送到哪里去
    private String to;

    // 消息内容
    private String content;

    // 消息发送的时间
    private Date time;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public InMessage() {
    }

    public InMessage(String content) {
        this.content = content;
    }
}
