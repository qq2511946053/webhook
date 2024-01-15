package com.webhook.notify.dingtalk;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DingRobotAt {

    private List<String> atMobiles;
    private List<String> atUserIds;
    private Boolean isAtAll = Boolean.FALSE;

    public String getAtMobilesString() {
        if (atMobiles == null) return "";
        StringBuilder at = new StringBuilder();
        for (String mobile : atMobiles) {
            at.append("@").append(mobile);
        }
        return at.toString();
    }
}
