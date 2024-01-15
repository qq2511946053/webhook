package com.webhook.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookConf {
    /**
     * 开启此配置 可启用 gitlab rest api
     */
    private GitlabConf gitlab;
}
