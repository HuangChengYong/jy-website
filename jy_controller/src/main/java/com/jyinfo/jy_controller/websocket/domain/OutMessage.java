package com.jyinfo.jy_controller.websocket.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: OutMessage
 * Author:   Huang
 * Date:     2020-09-18 10:40
 * Version: 1.0
 * Description: 传出的消息对象
 */
public class OutMessage implements Serializable {

    private String form;

    private String content;

    private Date time = new Date();

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
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

    public OutMessage() {
    }

    public OutMessage(String form, String content) {
        this.form = form;
        this.content = content;
    }
}
