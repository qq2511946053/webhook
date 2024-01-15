package com.webhook.core;

import com.webhook.model.Webhook;

/**
 * 事件处理器
 */
public interface EventHandler<D, R> {


    /**
     * 事件数据类型
     */
    Class<D> getDataType();

    /**
     * 处理请求事件
     *
     * @param data 事件数据
     */
    R handleEvent(Webhook webhook, D data);


}
