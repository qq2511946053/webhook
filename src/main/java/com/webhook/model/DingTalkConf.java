package com.webhook.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@Getter
@Setter
@ConfigurationPropertiesBinding
public class DingTalkConf {
    private String url = "https://oapi.dingtalk.com/robot/send";
    private String accessToken;
    private String signKey;
}
