package com.webhook.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Webhook {
  /**
   * webhook ID
   */
  private String id;
  /**
   * webhook 类型 会根据类型处理不同的事件类型
   */
  private WebhookType type;
  /**
   * 通知 配置
   */
  private NotifyConf notify;
  /**
   * webhook 配置
   */
  private WebhookConf conf;
}
