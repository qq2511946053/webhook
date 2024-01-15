package com.webhook.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(WebhookProperties.PREFIX)
@Validated
public class WebhookProperties {
    public static final String PREFIX = "config";
    @NotEmpty(message = "请配置webhooks")
    private List<Webhook> webhooks = new ArrayList<>();

}