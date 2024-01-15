package com.webhook.zhipuai.event;

import com.webhook.core.DefaultEventHandlerFactory;
import com.webhook.notify.NotifierFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * zhipuai 事件工厂
 */
public class ZhiPuAiEventFactory extends DefaultEventHandlerFactory {
    private final NotifierFactory notifierFactory;

    public ZhiPuAiEventFactory(ApplicationContext applicationContext, NotifierFactory notifierFactory) {
        super(applicationContext);
        this.notifierFactory = notifierFactory;
    }

    /**
     * 初始化注册zhipuai所有事件
     */
    @PostConstruct
    public void registerEvents() {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) getApplicationContext().getAutowireCapableBeanFactory();
        // zhipuai 通知类 事件处理器 xxxHookNotifyEventHandler
    }


}
