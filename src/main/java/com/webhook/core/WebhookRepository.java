package com.webhook.core;

import com.webhook.model.Webhook;

import java.util.List;

public interface WebhookRepository {

  /**
   * 获取所有的webhook
   */
  List<Webhook> getWebhooks();

  /**
   * 根据id 查询webhook
   */
  Webhook findById(String id);

  /**
   * 删除webhook
   */
  void remove(String id);
}
