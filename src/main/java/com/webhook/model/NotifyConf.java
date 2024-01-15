package com.webhook.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息通知配置
 */
@Getter
@Setter
public class NotifyConf {
    // 钉钉通知
    private DingTalkConf dingTalk;
}
