package com.webhook.notify.dingtalk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class MarkdownMessage {


    @JsonProperty("msgtype")
    private String msgType = "markdown";
    @Setter
    @Getter
    private Markdown markdown;
    private DingRobotAt at;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public DingRobotAt getAt() {
        return at;
    }

    public void setAt(DingRobotAt at) {
        this.at = at;
    }
}
