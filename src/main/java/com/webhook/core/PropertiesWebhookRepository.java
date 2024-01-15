package com.webhook.core;

import com.webhook.model.Webhook;
import com.webhook.model.WebhookProperties;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PropertiesWebhookRepository implements WebhookRepository{

  private final WebhookProperties properties;
  private final Map<String, Webhook> webhooks = new HashMap<>();

  public PropertiesWebhookRepository(WebhookProperties properties) {
    this.properties = properties;
    List<Webhook> webhookList = properties.getWebhooks();
    for (Webhook webhook : webhookList) {
      webhooks.put(webhook.getId(), webhook);
    }
  }

  @Override
  public List<Webhook> getWebhooks() {
    return properties.getWebhooks();
  }

  @Override
  public Webhook findById(String id) {
    return webhooks.get(id);
  }

  @Override
  public void remove(String id) {
    webhooks.remove(id);
  }
}
