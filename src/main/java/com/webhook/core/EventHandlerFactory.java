package com.webhook.core;

import com.webhook.model.Webhook;

import java.util.List;

/**
 * 事件处理器工厂
 */
public interface EventHandlerFactory {


  /**
   * 根据事件获取事件处理器
   * @param event   事件
   * @param webhook webhook
   * @return 一个事件有多个事件处理器
   */
  List<EventHandler<Object, Object>> getEventHandlers(String event, Webhook webhook);
}
