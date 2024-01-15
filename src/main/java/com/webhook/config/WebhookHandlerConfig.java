package com.webhook.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.notify.NotifierFactory;
import com.webhook.zhipuai.ZhiPuAiWebhookHandler;
import com.webhook.zhipuai.event.ZhiPuAiEventFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Webhook 处理器配置
 */
@Configuration
public class WebhookHandlerConfig {

    /**
     * zhipuai 事件工厂
     */
    @Bean
    public ZhiPuAiEventFactory gitlabEventFactory(ApplicationContext applicationContext, NotifierFactory notifierFactory) {
        return new ZhiPuAiEventFactory(applicationContext, notifierFactory);
    }

    /**
     * zhipuai Webhook 处理器
     * @param zhiPuAiEventFactory zhipuai事件工厂
     */
    @Bean
    public ZhiPuAiWebhookHandler gitlabWebhookHandler(ZhiPuAiEventFactory zhiPuAiEventFactory, ObjectMapper objectMapper) {
        return new ZhiPuAiWebhookHandler(zhiPuAiEventFactory, objectMapper);
    }


}
