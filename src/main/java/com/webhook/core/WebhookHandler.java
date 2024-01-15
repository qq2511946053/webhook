package com.webhook.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.webhook.model.Webhook;

public interface WebhookHandler<R> {


    /**
     * 处理webhook请求信息
     * @param params 请求参数
     * @return 返回对象
     */
    R handleWebhook(Webhook webhook, JsonNode params);

}
