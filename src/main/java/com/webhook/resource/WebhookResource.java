package com.webhook.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.webhook.core.WebhookExecutor;
import com.webhook.core.WebhookRepository;
import com.webhook.model.Webhook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebhookResource {

  public static final String ENDPOINT_URL = "/actuator";

  private final WebhookRepository webhookRepository;
  private final WebhookExecutor webhookExecutor;

  public WebhookResource(WebhookRepository webhookRepository, WebhookExecutor webhookExecutor) {
    this.webhookRepository = webhookRepository;
    this.webhookExecutor = webhookExecutor;
  }

  @PostMapping(ENDPOINT_URL + "/{id}")
  public ResponseEntity<Object> webhook(@PathVariable String id, @RequestBody JsonNode requestBody) {
    Webhook webhook = webhookRepository.findById(id);
    if (webhook == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(webhookExecutor.handleWebhook(webhook, requestBody));
  }
}
