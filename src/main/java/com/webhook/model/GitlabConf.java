package com.webhook.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitlabConf {
    private String host;
    private String privateToken;
}
