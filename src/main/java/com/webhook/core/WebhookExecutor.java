package com.webhook.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.webhook.model.Webhook;
import org.springframework.stereotype.Component;

@Component
public class WebhookExecutor {
  private final WebhookHandlerFactory webhookHandlerFactory;

  public WebhookExecutor(WebhookHandlerFactory webhookHandlerFactory) {
    this.webhookHandlerFactory = webhookHandlerFactory;
  }

  public Object handleWebhook(Webhook webhook, JsonNode json) {
    WebhookHandler<?> webhookHandler = webhookHandlerFactory.getWebhookHandler(webhook.getType());
    if (webhookHandler == null) {
      throw new UnsupportedOperationException("unsupported webhook handler");
    }
    return webhookHandler.handleWebhook(webhook, json);
  }
}
