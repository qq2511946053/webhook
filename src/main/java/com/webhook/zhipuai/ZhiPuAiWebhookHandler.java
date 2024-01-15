package com.webhook.zhipuai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.core.FactoryEventHandler;
import com.webhook.model.Webhook;
import com.webhook.zhipuai.event.ZhiPuAiEventFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author EalenXie created on 2023/4/14 12:39
 */
public class ZhiPuAiWebhookHandler extends FactoryEventHandler {
    public ZhiPuAiWebhookHandler(ZhiPuAiEventFactory zhiPuAiEventFactory, ObjectMapper objectMapper) {
        super(zhiPuAiEventFactory, objectMapper);
    }

    @Override
    public Object handleWebhook(Webhook webhook, JsonNode params) {
        // TODO
        // 1. 获取请求事件
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String event = request.getHeader("X-Gitlab-Event");
        if (ObjectUtils.isEmpty(event)) {
            throw new UnsupportedOperationException("Unable to get the Gitlab event type, please check that your webhook configuration is correct");
        }
        return handlerExecute(event, webhook, params);
    }


}
