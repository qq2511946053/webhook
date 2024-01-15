package com.webhook.notify;

import com.webhook.model.Webhook;
import com.webhook.notify.dingtalk.DingTalkNotifier;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NotifierFactory implements ApplicationContextAware {
    private final Map<String, List<Notifier<Object, Object>>> webhookNotifies = new HashMap<>();
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Notifier<?, ?> getNotifier(Class<? extends Notifier<?, ?>> clz) {
        return applicationContext.getBean(clz);
    }


    @SuppressWarnings("unchecked")
    public List<Notifier<Object, Object>> getNotifies(Webhook webhook) {
        List<Notifier<Object, Object>> notifiers = webhookNotifies.get(webhook.getId());
        if (notifiers == null) {
            notifiers = new ArrayList<>();
            if (webhook.getNotify().getDingTalk() != null) {
                notifiers.add((Notifier<Object, Object>) getNotifier(DingTalkNotifier.class));
            }
            webhookNotifies.put(webhook.getId(), notifiers);
        }
        return notifiers;
    }

}
