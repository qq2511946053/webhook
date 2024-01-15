package com.webhook.core;

import com.webhook.model.WebhookType;
import com.webhook.zhipuai.ZhiPuAiWebhookHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;

/**
 * Webhook 处理器工厂
 */
@Component
public class WebhookHandlerFactory implements ApplicationContextAware {

    private final EnumMap<WebhookType, WebhookHandler<?>> webhookHandlers = new EnumMap<>(WebhookType.class);
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        webhookHandlers.put(WebhookType.ZHIPU_AI, getWebhookHandler(ZhiPuAiWebhookHandler.class));
    }

    private WebhookHandler<?> getWebhookHandler(Class<?> clz) {
        return (WebhookHandler<?>) applicationContext.getBean(clz);
    }


    @SuppressWarnings("unchecked")
    public <H> WebhookHandler<H> getWebhookHandler(WebhookType webhookType) {
        return (WebhookHandler<H>) webhookHandlers.get(webhookType);
    }


}
